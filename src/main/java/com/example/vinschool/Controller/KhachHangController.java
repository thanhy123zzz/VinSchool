package com.example.vinschool.Controller;

import com.example.vinschool.Model.Accounts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.security.SecureRandom;

@Controller
public class KhachHangController extends Common {
    @GetMapping("/")
    public ModelAndView home(Principal principal) {
        mv.setViewName("index");
        try{
            mv.addObject("userName",principal.getName());
        }
        catch (NullPointerException ignored){

        }
        return mv;
    }
    @GetMapping("/news")
    public String news(){
        return "news";
    }
    @GetMapping("/education")
    public String education(){
        return "education";
    }
    @GetMapping("/admissions")
    public String admissions(){
        return "admissions";
    }
    @GetMapping("/rate")
    public String rate(){
        return "rating";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

}
