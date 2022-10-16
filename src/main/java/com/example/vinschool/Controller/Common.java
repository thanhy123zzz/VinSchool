package com.example.vinschool.Controller;

import com.example.vinschool.Model.TinTuc;
import com.example.vinschool.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

public class Common {

    ModelAndView mv = new ModelAndView();
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    ManagerService managerService;

    @Autowired
    TinTucService tinTucService;

    @Autowired
    AdminService adminService;

    @Autowired
    DanhGiaService danhGiaService;

    @Autowired
    CustomerService customerService;
}
