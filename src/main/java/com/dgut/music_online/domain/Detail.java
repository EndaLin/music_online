package com.dgut.music_online.domain;

import io.swagger.annotations.ApiModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope("prototype")
@ApiModel("封装response信息的实体")
public class Detail {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 细节
     */
    private Map<Object, Object> detail;

    public Detail() {
        this.code = 200;
        this.message = "响应成功";
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<Object, Object> getDetail() {
        return detail;
    }

    public void setDetail(Map<Object, Object> detail) {
        this.detail = detail;
    }
}
