package com.ghh.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @className: FeiclientConfig
 * @description: feiclient配置类
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2019-12-29 18:39
 **/
@Configuration
public class FeiclientConfig {

    /**
     *  eureka的用户名、密码
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicInterceptor(){
        return new BasicAuthRequestInterceptor("root","123456");
    }

    /**
     * feign的日志级别
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
     * mvc的注解
     * @return
     */
    @Bean
    public Contract feignContract(){
        return new SpringMvcContract();
    }
}
