package com.groupA.alpha.common.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.groupA.alpha.common.model.RequestMethodItem;
import com.groupA.alpha.common.model.RequestMethodParameter;



/**
 * 显示所有请求
 * 
 */
@Controller
@RequestMapping("/console")
public class ParamController {
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    
    private static LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    @ResponseBody
    @RequestMapping(value="")
    public ModelAndView getAllRequestMethod() {

        // request methods
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();

        List<RequestMethodItem> items = getMethodItems(handlerMethods);

        Collections.sort(items);

        ModelAndView mav = new ModelAndView();
        mav.addObject("itemList", items);
        mav.setViewName("jsp/console");
        return mav;

    }
  /**
   * 获得自己工程内的方法路径，并将参数由类替换成实际意义的名称
   * @author:wangchb
   * @param handlerMethod
   * @param parameters
   * @return
   * @time:2018年10月6日 下午1:54:55
   */
    private String translateMethod(HandlerMethod handlerMethod,List<RequestMethodParameter> parameters) {
    	String afterStr;
    	String parameterStr;
    	ArrayList<String> parameterArray = new ArrayList<String>();
    	for(RequestMethodParameter parameter : parameters) {
    		parameterArray.add(parameter.getName());
    	}
    	parameterStr = StringUtils.collectionToDelimitedString(parameterArray, ",");
    	String[] method = handlerMethod.toString().split(" ");
    	afterStr =method[method.length-1];
    	method = afterStr.split("\\(");
    	afterStr = method[0] + "(" + parameterStr +")";
    	
    	return afterStr;
    }
    /**
     * 通过HandlerMethod获得工程中的方法对象List
     * @author:wangchb
     * @param handlerMethods
     * @return
     * @time:2018年10月8日 上午11:12:34
     */
    private List<RequestMethodItem> getMethodItems(Map<RequestMappingInfo, HandlerMethod> handlerMethods){
    	List<RequestMethodItem> items = new ArrayList<RequestMethodItem>();
        
    	Set<RequestMappingInfo> keySet = handlerMethods.keySet();
        
        for (RequestMappingInfo requestMappingInfo : keySet) {
            // 请求路径
            String path = requestMappingInfo.getPatternsCondition().toString();

            // 请求方法
            String requestMethod = requestMappingInfo.getMethodsCondition().toString();

            // Controller的处理方法
            HandlerMethod handlerMethod = handlerMethods.get(requestMappingInfo);

            // 参数
            MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
           
            // 返回header类型
            String responseType = requestMappingInfo.getProducesCondition().toString();

            List<RequestMethodParameter> parameters =  getParameters(methodParameters);
            
            RequestMethodItem item = new RequestMethodItem();
            
            item.setPath(path);
            item.setRequestMethod(requestMethod);
            item.setParameters(parameters);
            item.setMethod(translateMethod(handlerMethod,parameters));
            item.setResponseType(responseType);
            
            items.add(item);
        }
        return items;
    }
    /**
     * 把methohdParameter参数数组变成参数的List,每个参数获取名称、类型、注解
     * @author:wangchb
     * @param methodParameters
     * @return
     * @time:2018年10月8日 上午11:03:35
     */
    private List<RequestMethodParameter> getParameters(MethodParameter[] methodParameters){
        List<RequestMethodParameter> parameters = new ArrayList<RequestMethodParameter>();

    	for (MethodParameter methodParameter : methodParameters) {
            // 参数名称
            // 如果没有discover参数会是null.参考LocalVariableTableParameterNameDiscoverer
            methodParameter.initParameterNameDiscovery(discoverer);
            String parameterName = methodParameter.getParameterName();

            // 参数类型
            Class<?> parameterType = methodParameter.getParameterType();

            // 参数注解
            Object[] parameterAnnotations = methodParameter.getParameterAnnotations();

            // 注解
            String annotation = Arrays.toString(parameterAnnotations);

            RequestMethodParameter parameter = new RequestMethodParameter();
            parameter.setAnnoation(annotation);
            parameter.setName(parameterName);
            parameter.setType(parameterType.toString());
            parameters.add(parameter);
        }
        return parameters;
    }
}