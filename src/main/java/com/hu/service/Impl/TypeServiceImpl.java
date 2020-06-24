package com.hu.service.Impl;

import com.hu.dao.TypeDao;
import com.hu.pojo.Type;
import com.hu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 博客分类展示业务实现类
 * @Package com.hu.service.Impl
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;



    @Transactional
    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Transactional
    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Override
    public List<Type> getAllTypeAndBlog() {
        return typeDao.getAllTypeAndBlog();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Transactional
    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeDao.deleteType(id);
    }



}