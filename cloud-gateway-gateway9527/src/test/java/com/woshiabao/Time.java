package com.woshiabao;/**
 * @description:
 * @author: jay
 * @time: 2021/12/18
 */

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *@ClassName T1
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
public class Time {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);
        //2021-12-18T23:59:26.640+08:00[Asia/Shanghai]
    }
}
