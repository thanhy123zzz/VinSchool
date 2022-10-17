package com.example.vinschool.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.vinschool.Model.Admin;
import com.example.vinschool.Model.Staff;
import com.example.vinschool.Model.Customer;

@RequestMapping("/manager")
@Controller
public class ManagerController extends Common {

    @GetMapping("/manager-admissions")
    public String admissions() {
        return "manager-admissions";
    }

    @GetMapping("/manager-account")
    public String account() {
        return "manager-account";
    }

    /* MANAGER USER(ADMIN + CUSTOMER + STAFF): */
    /* load LIST */
    @GetMapping("/manager-user")
    public ModelAndView user() {
        // Admin
        List<Admin> list = adminService.showList();
        mv.addObject("listAdmin", list);
        // Customer
        List<Customer> list1 = customerService.showList();
        mv.addObject("listCustomer", list1);
        // Staff
        List<Staff> list2 = staffService.showList();
        mv.addObject("listStaff", list2);
        mv.setViewName("manager-user");
        //
        return mv;
    }

    /* add a person */
    @PostMapping("/manager-user/addAdmin")
    public String createAdmin(Admin admin) {
        adminService.addAdmin(admin);
        return "redirect:/manager/manager-user";
    }

    /* edit a person */
    @PostMapping("/manager-user/editAdmin")
    public ModelAndView updateAdmin(Admin admin) {
        int a = adminService.editAdmin(admin);
        if(a>0){
            System.out.println("Sua thanh cong");
        }else{
            System.out.println("Sua that bai");

        }
        mv.setViewName("redirect:/manager/manager-user");
		return mv;
    }
    

    @GetMapping("/manager-user/findAdmin")
    @ResponseBody
    public Admin findAdmin(int id) {
        Admin admin = adminService.findOneById(id);
        return admin;
    }

    /* Remove a persen*/
    @GetMapping("/manager-user/removeAdmin")
	public String deleteAdmin(int id) {
		adminService.removeAdmin(id);
		return "redirect:/manager/manager-user";
	}



    @GetMapping("/manager-user/search" )
	public ModelAndView searchUser(@RequestParam("keyword") String search) {
		if (search == null) {
			List<Admin> list = adminService.showList();
			mv.addObject("listUser", list);
			mv.addObject("keyword", search);
			return mv;

		} else {
			List<Admin> list = adminService.searchByFullName(search);
			mv.addObject("listUser", list);
			mv.addObject("keyword", search);
			return mv;
		}
	}

    /* END MANAGER USER */

    @GetMapping("/manager-rate")
    public String rate() {
        return "manager-rate";
    }

    @GetMapping("/manager-events-news")
    public String news() {
        return "manager-events-news";
    }
}
