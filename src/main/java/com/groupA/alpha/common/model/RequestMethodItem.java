package com.groupA.alpha.common.model;

import java.util.List;

/**
 * 请求方法实例
 *
 */
public class RequestMethodItem implements Comparable<RequestMethodItem> {
    private String path;
    private String requestMethod;
    private String method;
    private String responseType;
    private List<RequestMethodParameter> parameters;

    public String getPath() {
        return path.replace("[", "").replace("]", "");
    }

    public void setPath(
                    String path) {
        this.path = path;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(
                    String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(
                    String method) {
        this.method = method;
    }

    public List<RequestMethodParameter> getParameters() {
        return parameters;
    }

    public void setParameters(
                    List<RequestMethodParameter> parameters) {
        this.parameters = parameters;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(
                    String responseType) {
        this.responseType = responseType;
    }


    @Override
    public String toString() {
        return "Item [path=" + path + ", requestMethod=" + requestMethod + ", method=" + method + ", responseType="
                        + responseType + ", parameters=" + parameters + "]";
    }

    public int compareTo(
                    RequestMethodItem o) {
        return this.getPath().compareTo(o.getPath());
    }


}