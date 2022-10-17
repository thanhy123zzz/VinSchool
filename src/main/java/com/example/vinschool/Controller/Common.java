package com.example.vinschool.Controller;

import com.example.vinschool.Service.AdminService;
import com.example.vinschool.Service.ManagerService;
import com.example.vinschool.Service.StaffService;
import com.example.vinschool.Service.CustomerService;
import com.example.vinschool.Service.AdmisionTicketService;
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
	AdminService adminService;

    @Autowired
    StaffService staffService;

    @Autowired
    CustomerService customerService;

    @Autowired
    AdmisionTicketService admisionTicketService;
}
