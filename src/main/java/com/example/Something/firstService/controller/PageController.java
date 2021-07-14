package com.example.Something.firstService.controller;

import com.example.Something.firstService.dto.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    @ResponseBody
    @GetMapping("/user")
    public UserRequest user() {
        var user = new UserRequest();
        user.setName("ddalam");
        user.setEmail("ddalam@mail.com");
        return user;
    }
}
