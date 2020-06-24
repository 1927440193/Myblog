package com.hu.controller;

import com.hu.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 照片展示页面控制器
 * @Package com.hu.controller
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Controller
public class PictureShowController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/picture")
    public String friends(Model model) {
        model.addAttribute("pictures",pictureService.listPicture());
        return "picture";
    }

}