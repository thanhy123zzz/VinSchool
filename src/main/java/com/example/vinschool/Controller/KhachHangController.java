package com.example.vinschool.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KhachHangController extends Common {
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/rate")
    public String rate(){
        return "rating";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/admissions")
    public String admissions(){
        return "admissions";
    }

    @GetMapping("/news")
    public String news(){
        return "news";
    }

    @GetMapping("/education")
    public String education(){
        return "education";
    }


    @GetMapping("/manager")
    public String QuanLy(){
        return "manager-admissions";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
