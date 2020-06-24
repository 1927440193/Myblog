package com.hu.service;

import com.hu.pojo.Blog;
import com.hu.vo.*;
import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 博客列表业务层接口
 * @Package com.hu.service
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
public interface BlogService {

    ShowBlog getBlogById(Long id);

    List<BlogQuery> getAllBlog();

    int saveBlog(Blog blog);

    int updateBlog(ShowBlog showBlog);

    void deleteBlog(Long id);

    void deleteBlogByType(Long typeId);

    List<BlogQuery> getBlogBySearch(SearchBlog searchBlog);

    List<FirstPageBlog> getAllFirstPageBlog();

    List<RecommendBlog> getRecommendedBlog();

//    List<FirstPageBlog> getNewBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    //根据TypeId获取博客列表，在分类页进行的操作
    List<FirstPageBlog> getByTypeId(Long typeId);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getBlogMessageTotal();

}