package com.ghh.springcloudcusterm.service;

import com.ghh.springcloudcusterm.utils.ResultUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @className: UserService
 * @description: 用户service
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2019-12-17 19:30
 **/
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getUserFailBack")
    public ResultUtils getUser(int id){
        //String url="http://127.0.0.1:8081/provider/user/getUser/"+id;
        String url = "http://127.0.0.1:8888/MyProject/user/getUser/"+id;
        ResultUtils resultUtils = restTemplate.getForObject(url,ResultUtils.class);
        return resultUtils;
    }

    /**
     * hystrix服务超时的回调
     * @param d
     * @return
     */
    public ResultUtils getUserFailBack(int d){
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setResultData("12345");
        resultUtils.setResultInfo("12345");
        resultUtils.setResultCode("12345");
        return resultUtils;
    }
}
