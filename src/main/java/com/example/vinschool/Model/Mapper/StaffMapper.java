package com.example.vinschool.Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.vinschool.Model.Staff;

public class StaffMapper implements RowMapper<Staff>{
    
    @Override
    public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
        Staff staff = new Staff();
        staff.setId(rs.getInt("IDNV"));
        staff.setFullname(rs.getString("Ten")); 
        // `Ten`, `NgaySinh`, `CCCD`, `Phone`, `Email`, `GioiTinh`, `TaiKhoan`
        staff.setBirthday(rs.getString("NgaySinh"));
        staff.setCitizenId(rs.getString("CCCD"));
        staff.setPhonenumber(rs.getString("Phone"));
        staff.setEmail(rs.getString("Email"));
        staff.setGender(rs.getBoolean("GioiTinh"));
        staff.setTaiKhoan(rs.getString("TaiKhoan"));
        staff.setWokingday(rs.getString("NgayBatDauLam"));
        return staff;
    }
}
