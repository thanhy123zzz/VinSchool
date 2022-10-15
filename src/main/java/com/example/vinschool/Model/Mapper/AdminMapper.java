package com.example.vinschool.Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.vinschool.Model.Admin;

public class AdminMapper implements RowMapper<Admin>{
    //IDADMIN
    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin Admin = new Admin();
        Admin.setId(rs.getInt("IDADMIN"));
        Admin.setFullname(rs.getString("Ten")); 
        // `Ten`, `NgaySinh`, `CCCD`, `Phone`, `Email`, `GioiTinh`, `TaiKhoan`
        Admin.setBirthday(rs.getString("NgaySinh"));
        Admin.setCitizenId(rs.getString("CCCD"));
        Admin.setPhonenumber(rs.getString("Phone"));
        Admin.setEmail(rs.getString("Email"));
        Admin.setGender(rs.getString("GioiTinh"));
        Admin.setTaiKhoan("TaiKhoan");
        return Admin;
    }
}
