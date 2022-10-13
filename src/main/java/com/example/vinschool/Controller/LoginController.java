package com.example.vinschool.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController extends Common{
    @GetMapping("/403")
    public String error(){
        return "403";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
