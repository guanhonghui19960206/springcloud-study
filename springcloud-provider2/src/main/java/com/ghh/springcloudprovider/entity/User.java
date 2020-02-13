package com.ghh.springcloudprovider.entity;

/**
 * @className: User
 * @description: 用户实体类
 * @author: 码畜7号
 * @email: 13972192525@163.com
 * @create: 2019-12-05 21:11
 **/
public class User {

    /**
     * 主键id
     */
    private int id;

    /**
     * 名字
     */
    private String name;

    /**
     * 年纪
     */
    private int age;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
