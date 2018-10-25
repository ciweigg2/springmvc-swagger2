package com.sx.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title:NormalController </p>
 * <p>Description:</p>
 * Created with IntelliJ IDEA.
 * User: maxiucheng
 * Date: 2018/3/13
 * Time: 11:43
 */
@Api(tags = "公共模块" ,description = "公共模块-基础段")
@Controller
@RequestMapping("/normal")
public class NormalController {

    @ApiOperation(value = "测试demo")
    @GetMapping("/normal")
    public String test1(Model model){
        System.out.println("你好啊");
        model.addAttribute("msg","Hello World");
        return "jsp";
    }
}
