package com.lansmancai.springmvctest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/hello")
public class Hello {
    @RequestMapping("/Getdate")
    public ModelAndView Getdate(){
        Date date = new Date();
        ModelAndView mv = new ModelAndView();
        mv.addObject("date", date);
        mv.setViewName("index");
        return mv;
    }
}
