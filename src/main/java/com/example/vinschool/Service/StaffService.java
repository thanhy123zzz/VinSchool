package com.example.vinschool.Service;

import java.util.List;

import com.example.vinschool.Model.Staff;

public interface StaffService{
    List<Staff> showList();
    int addStaff(Staff Staff);
    int editStaff(Staff Staff);
    int removeStaff(int id);
}
