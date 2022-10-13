package com.example.vinschool.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/manager")
@Controller
public class ManagerController extends Common {
    @GetMapping("/manager-admissions")
    public String admissions(){
        return "manager-admissions";
    }

    @GetMapping("/manager-account")
    public String account(){
        return "manager-account";
    }

    @GetMapping("/manager-user")
    public String user(){
        return "manager-user";
    }

    @GetMapping("/manager-rate")
    public String rate(){
        return "manager-rate";
    }

    @GetMapping("/manager-events-news")
    public String news(){
        return "manager-events-news";
    }
}
