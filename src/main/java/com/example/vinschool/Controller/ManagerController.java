package com.example.vinschool.Controller;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController extends Common {
    @GetMapping("/manager-account")
    public String manageraccount(){
        return "manager-account";
    }

    @GetMapping("/manager-admissions")
    public String manageradmissions(){
        return "manager-admissions";
    }

    @GetMapping("/manager-events-news")
    public String managerEventNews(){
        return "manager-events-news";
    } 

    @GetMapping("/manager-rate")
    public String managerRate(){
        return "manager-rate";
    } 

    @GetMapping("/manager-user")
    public String managerUser(){
        return "manager-user";
    }
=======

@Controller
public class ManagerController extends Common {
>>>>>>> c7d26979aed3f3e9dcaaa534cbc6562701285f4a
}
