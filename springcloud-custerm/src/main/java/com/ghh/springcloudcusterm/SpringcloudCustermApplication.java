package com.ghh.springcloudcusterm;

import com.ghh.springcloudcusterm.annocation.ExcludeRibbonNew;
import com.ghh.springcloudcusterm.config.RibbonNewConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@RibbonClient(name = "springcloud-provider",configuration = RibbonNewConfig.class)
@EnableHystrix
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeRibbonNew.class)})
public class SpringcloudCustermApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudCustermApplication.class, args);
    }

}
