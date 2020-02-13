package com.ghh.springcloudcusterm.feignInterface.fallBack;

import com.ghh.springcloudcusterm.feignInterface.FeignUser;
import com.ghh.springcloudcusterm.utils.ResultUtils;
import org.springframework.stereotype.Component;

/**
 * @className: FeignUserBack
 * @description: FeignUser的熔断类
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2020-01-07 15:30
 **/
@Component
public class FeignUserBack implements FeignUser{

    @Override
    public ResultUtils getUser(int id) {
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setResultCode("1");
        resultUtils.setResultInfo("我是feignClient熔断了");
        resultUtils.setResultData("测试====");
        return resultUtils;
    }
}
