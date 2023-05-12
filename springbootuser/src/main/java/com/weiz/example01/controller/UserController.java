package com.weiz.example01.controller;

import com.weiz.example01.model.User;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getUser")
    public User getUser(){
        User u = new User();
        u.setName("weiz222");
        u.setAge(20);
        u.setPassword("weiz222");
        return u;
    }

    @PostMapping(path = "/save")
    public String save(@RequestBody User user) {
        String name = user.getName();
        return name;
    }

    @PostMapping(path = "/check")
    public String check(@RequestBody @Valid User user, BindingResult result) {
        String name = user.getName();
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
        return name;
    }

    @RequestMapping("/query")
    public String query(@Range(min = 1, max = 9, message = "姓名长度错误，姓名长度2-10！")
                        @RequestParam(name = "name", required = true) String name,
                        @Min(value = 18, message = "年龄最小18")
                        @Max(value = 65, message = "年龄最大只能99")
                        @RequestParam(name = "age", required = true) Integer age,BindingResult result){
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
        System.out.println(name + "," + age);
        return name + "," + age;
    }
}
