package com.woshiabao.springcloud.entities;/**
 * @description:
 * @author: jay
 * @time: 2021/11/29
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *@ClassName Payment
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
