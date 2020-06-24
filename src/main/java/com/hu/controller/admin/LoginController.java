package com.hu.controller.admin;

import com.hu.pojo.User;
import com.hu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 用户登录管理控制器
 * @Package com.hu.controller
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * @Description: 跳转登录页面
     * @Auther: 胡学俊
     * @Date:  2020/3/21
     * @Param:
     * @Return: 返回登录页面
     */
    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    /**
     * @Description: 登录校验
     * @Auther: 胡学俊
     * @Date: 2020/3/21
     * @Param: username:用户名
     * @Param: password:密码
     * @Param: session:session域
     * @Param: attributes:返回页面消息
     * @Return: 登录成功跳转登录成功页面，登录失败返回登录页面
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }

    /**
     * @Description: 注销
     * @Auther: 胡学俊
     * @Date: 2020/3/21
     * @Param: session:session域
     * @Return: 返回登录页面
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}