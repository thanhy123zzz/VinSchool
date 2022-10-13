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


    @GetMapping("/manager")
    public String QuanLy(){
        return "manager-admissions";
    }

}
