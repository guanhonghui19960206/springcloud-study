package com.ghh.springcloudcusterm.config;

import com.ghh.springcloudcusterm.annocation.ExcludeRibbonNew;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: RibbonNewConfig
 * @description: 新的测试类配置
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2019-12-22 16:07
 **/
@Configuration
@ExcludeRibbonNew
public class RibbonNewConfig {

    @Autowired
    private IClientConfig config;

    /**
     * 随机访问的规则
     * @param config
     * @return
     */
    @Bean
    public IRule ribbonRule(IClientConfig config){
        return new RandomRule();
    }

}
