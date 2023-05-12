package com.weiz.example01.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class User {
    @NotBlank(message = "姓名不允许为空！")
    @Length(min = 2,max = 10,message = "姓名长度错误，姓名长度2-10！")
    private String name;

    @NotNull(message = "年龄不能为空！")
    @Min(18)
    private Integer age;

    @NotBlank(message = "密码不允许为空！")
    @Length(min = 6,max = 20,message = "密码长度错误，密码长度6-20！")
    private  String password;

    @Email(message = "邮箱格式错误")
    private String email;

    private  String desc;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesc() {
        return desc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
