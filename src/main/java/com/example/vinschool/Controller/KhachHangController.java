package com.example.vinschool.Controller;

import com.example.vinschool.Model.Accounts;
import com.example.vinschool.Model.AdmissionTicket;
import com.example.vinschool.Model.Customer;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class KhachHangController extends Common {
    @GetMapping("/")
    public ModelAndView home(Principal principal) {
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/news")
    public String news() {
        return "news";
    }

    @GetMapping("/education")
    public String education() {
        return "education";
    }

    @GetMapping("/admissions")
    public String admissions(Principal principal, Model model) {
        /* Viet them bắt đăng nhạp mới vô dc */
        Customer cus = customerService.findIDCustomers(principal.getName()); /* this id cus use add admissionTicket */
        System.out.println(cus.toString());
        /* check id exist in admissionTicket */
        List<AdmissionTicket> listCustomer = admisionTicketService.checkIDCustomers(cus.getId());
        AdmissionTicket ad = new AdmissionTicket(cus.getId());
        if (listCustomer.size() > 0) {
            // mv.addObject("showdetail", "turnon");
            // mv.addObject("AdmissionTicket", listCustomer.get(0));
            model.addAttribute("showdetail", "bat qq");
            model.addAttribute("AdmissionTicket", listCustomer.get(0));
            // for (AdmissionTicket ad : listCustomer) {
            // System.out.println("Id check: " + ad.getId() + ad.toString());
            // }
        } else {
            mv.addObject("showdetail", "");
            model.addAttribute("AdmissionTicket", ad);
        }
        return "admissions";
    }

    /* Insert Admission */
    @PostMapping("/admissions/confirm")
    public String comfirmAdmission(AdmissionTicket admissionTicket) {
        admisionTicketService.addAdmissionTicket(admissionTicket);
        return "redirect:/admissions";
    }

    @GetMapping("/rate")
    public String rate() {
        return "rating";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

}
