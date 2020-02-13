package com.ghh.springcloudprovider.service;

import com.ghh.springcloudprovider.entity.User;
import com.ghh.springcloudprovider.mapper.UserMapper;
import com.ghh.springcloudprovider.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @className: UserService
 * @description: 用户逻辑类
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2019-12-17 09:04
 **/
@Service
public class UserService {

    /**
     * 日志对象
     */
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    public ResultUtils getUserList(@PathVariable("id") int id){

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ResultUtils resultUtils = new ResultUtils();
        User user = userMapper.selectUserById(id);
        if(null == user){
            resultUtils.setResultCode("1");
            resultUtils.setResultInfo("没有数据");
            resultUtils.setResultData(null);
        }else {
            resultUtils.setResultCode("0");
            resultUtils.setResultInfo("provider工程");
            resultUtils.setResultData(user);
        }

        return  resultUtils;
    }

}
