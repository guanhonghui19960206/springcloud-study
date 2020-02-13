package com.ghh.springcloudcusterm.feignInterface;

import com.ghh.config.FeiclientConfig;
import com.ghh.springcloudcusterm.feignInterface.fallBack.FeignUserBack;
import com.ghh.springcloudcusterm.feignInterface.fallBack.FeignUserFactoryBack;
import com.ghh.springcloudcusterm.utils.ResultUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className: FeignUser
 * @description: feign用户类
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2019-12-25 22:58
 **/
//@FeignClient(name = "springcloud-provider",fallback = FeignUserBack.class ,configuration = FeiclientConfig.class)
@FeignClient(name = "springcloud-provider",fallbackFactory = FeignUserFactoryBack.class ,configuration = FeiclientConfig.class)
//@FeignClient(name = "springcloud-provider",fallback = FeignUserBack.class)
public interface FeignUser {

    @RequestMapping(value = "/user/getUser/{id}")
    ResultUtils getUser(@PathVariable("id") int id);

}
