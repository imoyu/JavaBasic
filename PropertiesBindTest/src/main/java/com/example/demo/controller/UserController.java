package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private User user;

    @ResponseBody
    @RequestMapping(value = "user")
    public User getUser() {
        return user;
    }

}
