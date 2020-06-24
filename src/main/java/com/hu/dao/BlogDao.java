package com.hu.dao;

import com.hu.pojo.Blog;
import com.hu.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 博客持久层接口
 * @Package com.hu.dao
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */

//@Mapper使用@mapper后，不需要在spring配置中设置扫描地址，
// 通过mapper.xml里面的namespace属性对应相关的mapper类，spring将动态的生成Bean后注入到ServiceImpl中。

/*
 * @Repository 它用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean。
 * @Service
 * @Controller
 * @Component 将类标识为Bean
 */

/*
 *@Repository的基础上增加了功能类似的额外三个注解：@Component、@Service、@Constroller，它们分别用于软件系统的不同层次：
 *@Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次。
 *@Service 通常作用在业务层，但是目前该功能与 @Component 相同。
 *@Constroller 通常作用在控制层，但是目前该功能与 @Component 相同。
  */
@Mapper
@Repository
public interface BlogDao {

    ShowBlog getBlogById(Long id);

    List<Blog> getAllBlog();

    List<BlogQuery> getAllBlogQuery();

    int saveBlog(Blog blog);

    int updateBlog(ShowBlog showBlog);

    void deleteBlog(Long id);

    void deleteBlogByType(Long typeId);

    List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);

    List<FirstPageBlog> getFirstPageBlog();

    List<RecommendBlog> getAllRecommendBlog();

//    List<FirstPageBlog> getNewBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    int updateViews(Long id);

    //    根据博客id查询出评论数量
    int getCommentCountById(Long id);

    List<FirstPageBlog> getByTypeId(Long typeId);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getBlogMessageTotal();
}
