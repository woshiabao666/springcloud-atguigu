package com.woshiabao.springcloud.entities;/**
 * @description:
 * @author: jay
 * @time: 2021/11/29
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@ClassName CommentResult
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult <T>{

    private Integer code;
    private String message;
    private T data;

    public CommentResult(Integer code, String message) {
        this(code,message,null);
    }
}
