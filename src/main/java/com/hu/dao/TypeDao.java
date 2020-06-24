package com.hu.dao;

import com.hu.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 文章分类持久层接口
 * @Package com.hu.dao
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Mapper
@Repository
public interface TypeDao {

    int saveType(Type type);

    Type getType(Long id);

    List<Type> getAllType();

    List<Type> getAllTypeAndBlog();

    Type getTypeByName(String name);

    int updateType(Type type);

    void deleteType(Long id);
}