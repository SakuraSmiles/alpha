package com.groupA.alpha.common.model;

/**
 * 请求参数
 * 
 */
public class RequestMethodParameter {
    private String name;
    private String annotation;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(
                    String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnoation(
                    String annotation) {
        this.annotation = annotation;
    }

    public String getType() {
        return type;
    }

    public void setType(
                    String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Parameter [name=" + name + ", annotation=" + annotation + ", type=" + type + "]";
    }
}