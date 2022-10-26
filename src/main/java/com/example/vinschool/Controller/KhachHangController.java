package com.example.vinschool.Controller;

import com.example.vinschool.Model.Accounts;
import com.example.vinschool.Model.AdmissionTicket;
import com.example.vinschool.Model.Customer;
import com.example.vinschool.Model.InforCheckOut;
import com.example.vinschool.Service.AdminService;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.security.SecureRandom;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KhachHangController extends Common {
    @GetMapping("/")
    public ModelAndView home(Principal principal) {
        mv.setViewName("index");
        try {
            mv.addObject("userName", principal.getName());
        } catch (NullPointerException ignored) {
        }
        mv.addObject("showactive", "1");
        return mv;
    }

    @GetMapping("/news")
    public ModelAndView news() {
        mv.setViewName("news");
        mv.addObject("soTrang", 5);
        mv.addObject("tinTucs", tinTucService.showList(5));
        mv.addObject("showactive", "2");
        return mv;
    }

    @PostMapping("/load-news")
    public ModelAndView news(@RequestParam("limit") int limit) {
        mv.addObject("tinTucs", tinTucService.showList(limit + 5));
        mv.setViewName("news :: #news");
        return mv;
    }

    @GetMapping("/load-image-tin/{idTin}")
    public void load_image(@PathVariable("idTin") int idTin, HttpServletResponse response)
            throws IOException, SQLException {
        response.setContentType("image/jpeg");

        Blob ph = tinTucService.findTin(idTin).getImage();

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    @GetMapping("/education")
    public ModelAndView education() {
        mv.addObject("showactive", "3");
        mv.setViewName("education");
        return mv;
    }

    @GetMapping("/admissions")
    public ModelAndView admissions(Principal principal) {
        /* Viet them bắt đăng nhạp mới vô dc */
        Customer cus = customerService.findIDCustomers(principal.getName()); /* this id cus use add admissionTicket */
        System.out.println(cus.toString());
        /* check id exist in admissionTicket */
        boolean check = admisionTicketService.checkIDCustomers(cus.getId());
        System.out.println(check);
        /* process null */
        AdmissionTicket AdmissionTicket = new AdmissionTicket(cus.getId());

        if (check == true) {
            List<AdmissionTicket> list = admisionTicketService.FindList(cus.getId());
            mv.addObject("showdetail", "");
            mv.addObject("AdmissionTicket", list.get(0));
            if (inforCheckOutService.CheckThongTinThanhToanByIdCus(cus.getId()) == true) {
                InforCheckOut inforCheckOut = inforCheckOutService.findThongTinThanhToanByIdCus(cus.getId()).get(0);
                mv.addObject("showcheckout", "");
                mv.addObject("inforCheckOut", inforCheckOut);
                mv.addObject("showBtn", "xxx");
            } else {
                mv.addObject("showcheckout", "xxx");
                mv.addObject("showBtn", "");

                // InforCheckOut iff = new InforCheckOut();
                // model.addAttribute("inforCheckOut", iff);
            }
            mv.addObject("showactive", "4");
            mv.setViewName("admissions");
            return mv;
        } else {
            // model.addAttribute("AdmissionTicket", ad);
            mv.setViewName("admissions");
            mv.addObject("showdetail", "xxxx");
            mv.addObject("AdmissionTicket", AdmissionTicket);
        }
        mv.addObject("showactive", "4");
        return mv;
    }

    /* Insert Admission */
    @PostMapping("/admissions/confirm")
    public ModelAndView comfirmAdmission(AdmissionTicket admissionTicket, Principal principal) {
        admisionTicketService.addAdmissionTicket(admissionTicket);
        // mv.addObject("AdmissionTicket", admissionTicket);
        mv.setViewName("redirect:/admissions");
        return mv;
    }

    @PostMapping("/showDataPayment")
    public ModelAndView showDataPayment(Principal principal) {
        Customer cus = customerService.findIDCustomers(principal.getName()); /* this id cus use add admissionTicket */
        // System.out.println(cus.toString());
        /* check id exist in admissionTicket */
        boolean check = admisionTicketService.checkIDCustomers(cus.getId());
        System.out.println(check);
        if (check == true) {
            List<AdmissionTicket> list = admisionTicketService.FindList(cus.getId());
            mv.addObject("AdmissionTicket", list.get(0));
        }
        mv.setViewName("admissions :: #formcheckout");
        return mv;
    }

    @PostMapping("/checkout")
    public String Checkout(InforCheckOut inforCheckOut) {
        inforCheckOutService.addThongtinthanhtoan(inforCheckOut);
        return "redirect:/admissions";
    }

    @GetMapping("/rate")
    public ModelAndView rate() {
        mv.addObject("showactive", "5");
        mv.setViewName("rating");
        return mv;
    }

    @GetMapping("/contact")
    public ModelAndView contact() {
        mv.addObject("showactive", "6");
        mv.setViewName("contact");
        return mv;
    }

    @GetMapping("/detail-news/{idTin}")
    public ModelAndView detail_News(@PathVariable("idTin") int id) {
        mv.setViewName("detail-news-events");
        mv.addObject("tin", tinTucService.findTin(id));
        return mv;
    }

    @PostMapping("/load-ten")
    public ModelAndView load_ten(int idkh) {
        mv.setViewName("<h5>" + customerService.inforCT(idkh).getFullname() + "</h5>");
        return mv;
    }

}
