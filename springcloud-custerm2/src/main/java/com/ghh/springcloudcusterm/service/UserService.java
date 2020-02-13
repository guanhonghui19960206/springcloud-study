package com.ghh.springcloudcusterm.service;

import com.ghh.springcloudcusterm.utils.ResultUtils;
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
    public ResultUtils getUser(int id){

        //String url="http://127.0.0.1:8081/provider/user/getUser/"+id;
        String url = "http://springcloud-provider/user/getUser/"+id;
        ResultUtils resultUtils = restTemplate.getForObject(url,ResultUtils.class);
        return resultUtils;
    }
}
