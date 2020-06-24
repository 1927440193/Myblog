package com.hu.service;


import com.hu.pojo.Type;

import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 博客分类业务层接口
 * @Package com.hu.service
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    List<Type> getAllType();

    List<Type> getAllTypeAndBlog();

    Type getTypeByName(String name);

    int updateType(Type type);

    void deleteType(Long id);


}