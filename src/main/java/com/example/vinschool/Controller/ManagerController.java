package com.example.vinschool.Controller;

import org.springframework.stereotype.Controller;
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
}
