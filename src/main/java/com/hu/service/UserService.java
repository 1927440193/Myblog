package com.hu.service;

import com.hu.pojo.User;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 用户业务层接口
 * @Package com.hu.service
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
public interface UserService {

    //核对用户名和密码
    User checkUser(String username, String password);

}