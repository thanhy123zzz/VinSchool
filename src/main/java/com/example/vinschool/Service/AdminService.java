package com.example.vinschool.Service;

import java.util.List;

import com.example.vinschool.Model.Admin;

public interface AdminService {
    List<Admin> showList();
    int addAdmin(Admin Admin);
    int editAdmin(Admin Admin);
    int removeAdmin(int id);
    Admin findOneById(int id);
    List<Admin> searchByFullName(String fullname);
    Admin showAdmin(String TaiKhoan);
}
