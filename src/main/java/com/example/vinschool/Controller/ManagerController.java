package com.example.vinschool.Controller;

import com.example.vinschool.Model.Admin;
import com.example.vinschool.Model.DanhGia;
import com.example.vinschool.Model.TinTuc;
import com.example.vinschool.Service.TinTucService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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
    public ModelAndView rate(){
        List<DanhGia> list = danhGiaService.showList(5);
        mv.setViewName("manager-rate");
        mv.addObject("rates",list);
        return mv;
    }
    @PostMapping("/xoa-rate")
    public ModelAndView xoa_rate(int idKH){
        danhGiaService.xoaDanhGia(idKH);
        List<DanhGia> list = danhGiaService.showList(5);
        mv.addObject("rates",list);
        mv.setViewName("manager-rate :: #rates");
        return mv;
    }
    @PostMapping("/find-rate")
    public ModelAndView find_rate(String key){
        List<DanhGia> list = danhGiaService.find(key);
        mv.addObject("rates",list);
        mv.setViewName("manager-rate :: #rates");
        return mv;
    }

    @GetMapping("/manager-events-news")
    public ModelAndView news(){
        mv.setViewName("manager-events-news");
        mv.addObject("tin",new TinTuc());
        mv.addObject("tinTucs",tinTucService.showList(5));
        return mv;
    }
    @PostMapping("/load-news")
    public ModelAndView news(@RequestParam("limit") int limit){
        mv.addObject("tinTucs",tinTucService.showList(limit+5));
        mv.setViewName("manager-events-news :: #news");
        return mv;
    }

    @PostMapping("/manager-insert-tin")
    public ModelAndView add_tin(TinTuc tinTuc, Principal principal) throws IOException {
       tinTuc.setIdADMIN(adminService.showAdmin(principal.getName()).getId());
        tinTucService.insertTin(tinTuc);
        mv.setViewName("redirect:/manager/manager-events-news");
        return mv;
    }

    @PostMapping("/load-modal-sua-tin")
    public ModelAndView load_modal_sua(@RequestParam("idTin") int idTin){
        mv.setViewName("manager-events-news :: #sua_tin");
        mv.addObject("tin",tinTucService.findTin(idTin));
        return mv;
    }

    @PostMapping("/sua-tin")
    public ModelAndView load_modal_sua(TinTuc tinTuc) throws IOException {
        mv.setViewName("redirect:/manager/manager-events-news");
        int kq = tinTucService.suaTin(tinTuc);
        return mv;
    }

    @PostMapping("/xoa-tin")
    public ModelAndView xoa_tin(int idTin){
        tinTucService.xoaTin(idTin);
        mv.addObject("tinTucs",tinTucService.showList(5));
        mv.setViewName("manager-events-news :: #news");
        return mv;
    }

}
