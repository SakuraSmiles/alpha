package com.sakuraSmiles.alpha.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.sakuraSmiles.alpha.security.handler.AjaxAuthenticationEntryPoint;
import com.sakuraSmiles.alpha.security.handler.AjaxAuthenticationFailureHandler;
import com.sakuraSmiles.alpha.security.handler.AjaxAuthenticationSuccessHandler;
import com.sakuraSmiles.alpha.security.handler.AuthenticationAccessDeniedHandler;
import com.sakuraSmiles.alpha.security.service.SecurityService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SecurityService securityService;
    @Autowired
    UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;
    @Autowired
    AjaxAuthenticationSuccessHandler authenticationSuccessHandler;  // 登录成功返回的 JSON 格式数据给前端（否则为 html）
    @Autowired
    AjaxAuthenticationFailureHandler authenticationFailureHandler;  //  登录失败返回的 JSON 格式数据给前端（否则为 html）
    @Autowired
    AjaxAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/console","/index**","/resources/**","/druid/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.httpBasic().authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.formLogin()
		.usernameParameter("username")
		.passwordParameter("password")
		.failureHandler(authenticationFailureHandler)
		.successHandler(authenticationSuccessHandler)
		.permitAll()

		.and()
		.logout()
		.permitAll()

		.and()
		.exceptionHandling()
		.accessDeniedHandler(authenticationAccessDeniedHandler)

		.and()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
			@Override
			public <O extends FilterSecurityInterceptor> O postProcess(O o) {
				o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
				o.setAccessDecisionManager(urlAccessDecisionManager);
				return o;
			}
		});
	}
}

