package com.example.vinschool.DAO;

import java.util.List;

import com.example.vinschool.Model.Admin;

public interface AdminDAO {
    List<Admin> showList();
    int addAdmin(Admin Admin);
    int editAdmin(Admin Admin);
    int removeAdmin(int id);
    List<Admin> findById(int id);
    List<Admin> searchByFullName(String fullname);
    Admin showAdmin(String TaiKhoan);
}
