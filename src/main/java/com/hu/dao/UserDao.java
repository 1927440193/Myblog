package com.hu.dao;

import com.hu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 用户持久层接口
 * @Package com.hu.dao
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Mapper
@Repository
public interface UserDao {
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
