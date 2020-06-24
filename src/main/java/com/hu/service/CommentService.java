package com.hu.service;

import com.hu.pojo.Comment;

import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 博客评论业务层接口
 * @Package com.hu.service
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment);

//    查询子评论
//    List<Comment> getChildComment(Long blogId,Long id);

    //删除评论
    void deleteComment(Comment comment, Long id);

}