package com.ghh.springcloudprovider.mapper;

import com.ghh.springcloudprovider.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: UserMapper
 * @description: mapper接口
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2019-12-17 09:05
 **/
@Mapper
public interface UserMapper {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User selectUserById(int id);
}
