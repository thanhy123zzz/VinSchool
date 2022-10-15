package com.example.vinschool.DAO;

import java.util.List;

import com.example.vinschool.Model.Staff;

public interface StaffDAO {
    List<Staff> showList();
    int addStaff(Staff Staff);
    int editStaff(Staff Staff);
    int removeStaff(int id);
}
