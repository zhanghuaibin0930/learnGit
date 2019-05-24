package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response<T> {
    /**
     * 状态码
     */
    @JsonProperty(value = "status")
    private int code;

    /**
     * 描述
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "message")
    private String description = null;

    /**
     * 更新时间
     */
    private long lastUpdateTime = System.currentTimeMillis();

    /**
     * 数据内容
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "data")
    private T payload;

}
