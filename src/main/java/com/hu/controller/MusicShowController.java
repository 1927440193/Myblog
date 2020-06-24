package com.hu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 音乐盒控制器
 * @Package com.hu.controller
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Controller
public class MusicShowController {

    @GetMapping("/music")
    public String about() {
        return "music";
    }

}