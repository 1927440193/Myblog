package com.hu.service.Impl;

import com.hu.dao.UserDao;
import com.hu.pojo.User;
import com.hu.service.UserService;
import com.hu.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 用户业务实现类
 * @Package com.hu.service.Impl
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}