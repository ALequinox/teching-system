package com.alw.teching_system.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 返回消息包装类
 */
@Data
public class Message {
    private Integer code;
    private String message;

    @Override
    public String toString() {
        return "{" +
                "'code'="+ code +
                ", 'message'='"+ message +
                "'}";
    }
}
