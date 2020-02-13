package com.ghh.springcloudcusterm.feignInterface.fallBack;

import com.ghh.springcloudcusterm.feignInterface.FeignUser;
import com.ghh.springcloudcusterm.utils.ResultUtils;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @className: FeignUserFactoryBack
 * @description: FeignUserFactoryback类
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2020-01-08 08:44
 **/
@Component
public class FeignUserFactoryBack implements FallbackFactory<FeignUser> {

    @Override
    public FeignUser create(Throwable throwable) {
        return new FeignUser() {
            @Override
            public ResultUtils getUser(int id) {
                ResultUtils resultUtils = new ResultUtils();
                resultUtils.setResultData("我是factory降级后的服务");
                resultUtils.setResultInfo("我是factory降级后的服务");
                resultUtils.setResultCode("0");
                return resultUtils;
            }
        };
    }
}
