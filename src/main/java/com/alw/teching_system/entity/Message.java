package com.alw.teching_system.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 返回消息包装类
 */
@ToString
@Data
public class Message {
    private Integer code;
    private String message;

}
