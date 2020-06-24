package com.hu.dao;

import com.hu.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 留言持久层接口
 * @Package com.hu.dao
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Mapper
@Repository
public interface MessageDao {

    //添加一个评论
    int saveMessage(Message message);

    //查询父级评论
    List<Message> findByParentIdNull(@Param("ParentId") Long ParentId);

    //查询一级回复
    List<Message> findByParentIdNotNull(@Param("id") Long id);

    //查询二级以及所有子集回复
    List<Message> findByReplayId(@Param("childId") Long childId);

    //删除评论
    void deleteMessage(Long id);

}