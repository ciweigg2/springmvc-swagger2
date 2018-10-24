package com.sx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title:NormalController </p>
 * <p>Description:</p>
 * Created with IntelliJ IDEA.
 * User: maxiucheng
 * Date: 2018/3/13
 * Time: 11:43
 */
@Controller
public class NormalController {

    @RequestMapping("/normal")
    public String test1(Model model){
        System.out.println("你好啊");
        model.addAttribute("msg","Hello World");
        return "jsp";
    }
}
