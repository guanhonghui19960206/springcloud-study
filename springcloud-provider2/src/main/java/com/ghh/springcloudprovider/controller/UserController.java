package com.ghh.springcloudprovider.controller;

import com.ghh.springcloudprovider.entity.User;
import com.ghh.springcloudprovider.service.UserService;
import com.ghh.springcloudprovider.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className: UserController
 * @description: 用户测试controller
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2019-12-16 15:35
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController  {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/getUser/{id}")
    @ResponseBody
    public ResultUtils getHello(@PathVariable("id") int id){
        Long beginTime = System.currentTimeMillis();//开始时间
        ResultUtils resultUtils = new ResultUtils();
        try {
            logger.info("工程provider：获取的id为：{}",id);
            resultUtils = userService.getUserList(id);
        } catch (Exception e) {
            logger.error("获取用户异常：",e);
        } finally {
            Long endTime = System.currentTimeMillis();//结束时间
            logger.info("查询完成，耗时：{}毫秒",endTime - beginTime);
        }

        return  resultUtils;
    }
}
