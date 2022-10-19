package com.example.vinschool.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vinschool.DAO.AdminDAO;
import com.example.vinschool.Model.Admin;
import com.example.vinschool.Service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService{
    @Autowired
    private AdminDAO AdminDAO;

    @Override
    public List<Admin> showList(){
        return AdminDAO.showList();
    }

    @Override
    public int addAdmin(Admin Admin){
        return AdminDAO.addAdmin(Admin);
    }

    @Override
    public int editAdmin(Admin Admin){
        return AdminDAO.editAdmin(Admin);
    }

    @Override
    public int removeAdmin(int id){
        return AdminDAO.removeAdmin(id);
    }

    @Override
    public Admin findOneById(int id){
        return AdminDAO.findById(id).get(0);
    }

    @Override
    public List<Admin> searchByFullName(String fullname) {
        return AdminDAO.searchByFullName(fullname);
    }

    @Override
    public Admin showAdmin(String TaiKhoan) {
        return AdminDAO.showAdmin(TaiKhoan);
    }
}
