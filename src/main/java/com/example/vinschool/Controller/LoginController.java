package com.example.vinschool.Controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.vinschool.Model.Accounts;
import com.example.vinschool.Model.Customer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class LoginController extends Common{
    @GetMapping("/403")
    public String error(){
        return "403";
    }

    @GetMapping("/login")
    public ModelAndView login(String success){
        mv.addObject("userName","");
        if(Objects.equals(success, "fail")) {
            mv.addObject("message", "Đăng nhập thất bại");
        }
        mv.setViewName("login");
        return mv;
    }

    @GetMapping("/signup")
    public ModelAndView signup(){
        mv.addObject("message","");
        mv.setViewName("signup");
        return mv;
    }

    @PostMapping("/check-account")
    public ModelAndView check_account(@RequestParam("userName") String userName){
        if(managerService.checkAccount(userName))
        {
            mv.addObject("message","");
            mv.setViewName("signup :: #message");
            return mv;

        }else{
            mv.addObject("message","Tài khoản đã tồn tại");
            mv.setViewName("signup :: #message");
            return mv;
        }
    }
    @PostMapping("/login")
    public ModelAndView insert_account(Accounts accounts){
        accounts.setIDrole("KHACHHANG");
        accounts.setMatKhau(passwordEncoder.encode(accounts.getMatKhau()));
        managerService.insertAccount(accounts);
        Customer ct = new Customer();
        ct.setFullname(accounts.getTaiKhoan());
        ct.setTaiKhoan(accounts.getTaiKhoan());
        customerService.addNullCustomer(ct);
        mv.setViewName("login");
        mv.addObject("userName",accounts.getTaiKhoan());
        return mv;
    }
}
