package com.sakuraSmiles.alpha.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sakuraSmiles.alpha.utils.IpUtil;
import com.sakuraSmiles.alpha.security.model.SysUser;
import com.sakuraSmiles.alpha.security.repository.SysUserRepository;

@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
    SysUserRepository userRepository;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        String loginname = authentication.getName();
        String ipAddress =IpUtil.getIpAddr(httpServletRequest);
        this.updateLastLoginMsg((SysUser)authentication.getPrincipal(),ipAddress);
        String s = "{\"status\":\"200\",\"msg\":" + objectMapper.writeValueAsString("登录成功！") + ",\"info\":{\"name\":" + loginname + "}}";
        out.write(s);
        out.flush();
        out.close();
    }
    private void updateLastLoginMsg(SysUser user,String ipAddress) {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String currentTime = df.format(new Date());// new Date()为获取当前系统时间
    	String lastLoginTime = user.getCurrentLoginTime();
    	String lastLoginIp = user.getCurrentLoginIp();
        System.out.println("登陆ip: " + ipAddress +"登陆时间: " + currentTime);
        user.setCurrentLoginTime(currentTime);
        user.setCurrentLoginIp(ipAddress);
        user.setLastLoginTime(lastLoginTime);
        user.setLastLoginIp(lastLoginIp);
        userRepository.save(user);
    }
    
}
