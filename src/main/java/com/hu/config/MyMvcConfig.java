package com.hu.config;

import com.hu.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 指定拦截内容的配置类
 * @Package com.hu.config
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //新增拦截器--登录拦截；/admin地址下所有访问都拦截； /admin/index.html等除外
        registry.addInterceptor(new LoginInterceptor()) /* 拦截规则*/
                .addPathPatterns("/admin/**") /* 拦截地址*/
                .excludePathPatterns("/admin/index.html","/admin/login","/admin","/css/**","/js/**","/images/**","/lib/**");/*例外*/

    }
}
