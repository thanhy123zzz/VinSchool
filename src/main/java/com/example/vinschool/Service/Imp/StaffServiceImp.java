package com.example.vinschool.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.vinschool.DAO.StaffDAO;
import com.example.vinschool.Model.Staff;
import com.example.vinschool.Service.StaffService;

public class StaffServiceImp implements StaffService{
    @Autowired
    private StaffDAO StaffDAO;

    @Override
    public List<Staff> showList(){
        return StaffDAO.showList();
    }

    @Override
    public int addStaff(Staff Staff){
        return StaffDAO.addStaff(Staff);
    }

    @Override
    public int editStaff(Staff Staff){
        return StaffDAO.editStaff(Staff);
    }

    @Override
    public int removeStaff(int id){
        return StaffDAO.removeStaff(id);
    }
}
