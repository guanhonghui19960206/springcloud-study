package com.ghh.springcloudcusterm.controller;

import com.ghh.springcloudcusterm.feignInterface.FeignUser;
import com.ghh.springcloudcusterm.service.UserService;
import com.ghh.springcloudcusterm.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className: UserController
 * @description: 用户消费者
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2019-12-16 21:55
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private FeignUser feignUser;

    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResultUtils getUser(@PathVariable("id") int id){

        Long beginTime = System.currentTimeMillis();

        logger.info("接受的id：{}",id);
        ResultUtils resultUtils = new ResultUtils();

        try {
            //resultUtils = userService.getUser(id);
            resultUtils = this.feignUser.getUser(id);
        } catch (Exception e) {
            logger.error("查询异常：",e);
        } finally {
            Long endTime = System.currentTimeMillis();
            logger.info("查询耗时:{}毫秒",endTime - beginTime);
        }

        return resultUtils;
    }


    /**
     * 测试访问规则
     * @return
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public ResultUtils testRibbon(){

        ResultUtils resultUtils = new ResultUtils();
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("springcloud-provider");

        resultUtils.setResultInfo("provider8081-8083："+serviceInstance.getServiceId()+":"+serviceInstance.getHost()+":"+serviceInstance.getPort());

        ServiceInstance serviceInstance1 = this.loadBalancerClient.choose("springcloud-provider2");

        resultUtils.setResultData("provider28085-8084："+serviceInstance1.getServiceId()+":"+serviceInstance1.getHost()+":"+serviceInstance1.getPort());
        return resultUtils;
    }
}
