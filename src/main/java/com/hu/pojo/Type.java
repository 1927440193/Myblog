package com.hu.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description
 * @Package com.hu.pojo
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
public class Type {
    private Long id;
    private String name;

    private List<Blog> blogs = new ArrayList<>();

    public Type() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
