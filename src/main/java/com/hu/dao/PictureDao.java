package com.hu.dao;

import com.hu.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 照片展示持久层接口
 * @Package com.hu.dao
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Mapper
@Repository
public interface PictureDao {

    List<Picture> listPicture();

    int savePicture(Picture picture);

    Picture getPicture(Long id);

    int updatePicture(Picture picture);

    void deletePicture(Long id);

}