package com.example.vinschool.Controller;

import com.example.vinschool.Model.Accounts;
import com.example.vinschool.Model.AdmissionTicket;
import com.example.vinschool.Model.Customer;

import com.example.vinschool.Model.DanhGia;
import com.example.vinschool.Model.header;
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
import java.util.List;

@Controller
public class KhachHangController extends Common {
    @GetMapping(value = {"/","/trang-chu"})
    public ModelAndView home(Principal principal) {
        mv.setViewName("index");
        mv.addObject("index",true);
        try{
            mv.addObject("userName",principal.getName());
        }
        catch (NullPointerException ignored){
        }
        return mv;
    }

    @GetMapping("/news")
    public ModelAndView news(){
        mv.setViewName("news");
        mv.addObject("soTrang",5);
        mv.addObject("tinTucs",tinTucService.showList(5));
        return mv;
    }

    @PostMapping("/load-news")
    public ModelAndView news(@RequestParam("limit") int limit){
        mv.addObject("tinTucs",tinTucService.showList(limit+5));
        mv.setViewName("news :: #news");
        return mv;
    }

    @GetMapping("/load-image-tin/{idTin}")
    public void load_image(@PathVariable("idTin") int idTin, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("image/jpeg");

        Blob ph = tinTucService.findTin(idTin).getImage();

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
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
    public ModelAndView rate(){
        List<DanhGia> list = danhGiaService.showList(5);
        int tong=0;
        for(DanhGia danhgia : list){
            tong+= danhgia.getRate();
        }
        float diem = (float) tong/(float)list.size();
        mv.setViewName("rating");
        mv.addObject("rates",list);
        mv.addObject("diem",(float) Math.round(diem * 100) / 100);
        return mv;
    }

    @PostMapping("/insert-danhgia")
    public ModelAndView insert_danhgia(@RequestParam("rate") int rate, DanhGia danhGia){
        danhGia.setIdKH(customerService.inforCT(danhGia.getTaiKhoan()).getId());
        danhGia.setRate(rate);
        danhGiaService.insertDanhGia(danhGia);
        mv.setViewName("redirect:/rate");
        return mv;
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/detail-news/{idTin}")
    public ModelAndView detail_News(@PathVariable("idTin") int id){
        mv.setViewName("detail-news-events");
        mv.addObject("tin",tinTucService.findTin(id));
        return mv;
    }

    @PostMapping("/load-ten")
    public ModelAndView load_ten(int idkh){
        mv.setViewName("<h5>"+customerService.inforCT(idkh).getFullname()+"</h5>");
        return mv;
    }
}
