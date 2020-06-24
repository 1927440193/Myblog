package com.hu.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hu.pojo.Blog;
import com.hu.pojo.Type;
import com.hu.pojo.User;
import com.hu.vo.BlogQuery;
import com.hu.vo.SearchBlog;
import com.hu.vo.ShowBlog;
import com.hu.service.BlogService;
import com.hu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 博客管理控制器
 * @Package com.hu.controller
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    //依赖注入 blogService+typeService
    //@Autowired按byType自动注入
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    //博客列表
    //@RequestMapping处理请求地址映射的注解
    @RequestMapping("/blogs")
    public String blogs(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //按照排序字段 倒序 排序
        String orderBy = "update_time desc";
        //把orderBy10个一组分页
        PageHelper.startPage(pageNum,10,orderBy);
        //调用getAllBlog方法获得博客列表
        List<BlogQuery> list = blogService.getAllBlog();
        PageInfo<BlogQuery> pageInfo = new PageInfo<BlogQuery>(list);
        //model用于传递数据，getAllType（）得到的数据，以types为名传到/admin/blogs
        model.addAttribute("types",typeService.getAllType());
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }

    //跳转博客新增页面
    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types",typeService.getAllType());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }

//    博客新增
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
        //从前端Session种获得user并转换为User类，赋值给Blog的User
        blog.setUser((User) session.getAttribute("user"));
        //设置blog的type
        blog.setType(typeService.getType(blog.getType().getId()));
        //设置blog中typeId属性
        blog.setTypeId(blog.getType().getId());
        //设置用户id
        blog.setUserId(blog.getUser().getId());
        //把saveBlog（blog）赋值给b
        int b = blogService.saveBlog(blog);
        //判断，如果b==0，说明保存无数据，则保存失败
        if(b == 0){
            attributes.addFlashAttribute("message", "新增失败");
        }else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        //保存不论成败，重定向到/admin/blogs；前端接受Message内容
        return "redirect:/admin/blogs";
    }

//    删除文章
    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/blogs";
    }

//    跳转编辑修改文章
    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        //通过Id获取博客全部信息
        ShowBlog blogById = blogService.getBlogById(id);
        //获得全部类型
        List<Type> allType = typeService.getAllType();
        //返回对应博客ID的博客对象
        model.addAttribute("blog", blogById);
        //返回全部类型信息
        model.addAttribute("types", allType);
        //返回admin/blogs-input页面
        return "admin/blogs-input";
    }

//    编辑修改文章
    @PostMapping("/blogs/{id}")
    public String editPost(@Valid ShowBlog showBlog, RedirectAttributes attributes) {
        int b = blogService.updateBlog(showBlog);
        if(b ==0){
            attributes.addFlashAttribute("message", "修改失败");
        }else {
            attributes.addFlashAttribute("message", "修改成功");
        }
        return "redirect:/admin/blogs";
    }

//    搜索博客
    @PostMapping("/blogs/search")
    public String search(SearchBlog searchBlog, Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        List<BlogQuery> blogBySearch = blogService.getBlogBySearch(searchBlog);
        PageHelper.startPage(pageNum, 10);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogBySearch);
        model.addAttribute("pageInfo", pageInfo);
        //blogs从blogList中依次获取
        return "admin/blogs :: blogList";
    }
}


