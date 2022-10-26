package com.example.vinschool.Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.vinschool.Model.InforCheckOut;

public class InforCheckOutMapper implements RowMapper<InforCheckOut>{

    @Override
    public InforCheckOut mapRow(ResultSet rs, int rowNum) throws SQLException {
        InforCheckOut inforCheckOut = new InforCheckOut();
        // INSERT INTO `vinschool`.`thongtinthanhtoan`(`idNV`,`idadmin`,`thue`,`tongtien`,`idPhieu`,`idHP`,`tenchuthe`,`sotaikhoan`,`ngayhethan`,`ngaythanhtoan`,`idTT`)VALUES();
        inforCheckOut.setIdTT(rs.getInt("idTT"));
        inforCheckOut.setIdTicket(rs.getInt("idPhieu"));
        inforCheckOut.setIdHP(rs.getString("idHP"));
        inforCheckOut.setThue(rs.getFloat("thue"));
        inforCheckOut.setTenchuthe(rs.getString("tenchuthe"));
        inforCheckOut.setSotaikhoan(rs.getString("sotaikhoan"));
        inforCheckOut.setNgayhethan(rs.getString("ngayhethan"));
        inforCheckOut.setNgaythanhtoan(rs.getString("ngaythanhtoan"));
        inforCheckOut.setTongtien((int)rs.getDouble("tongtien"));
        inforCheckOut.setFullnameBaby(rs.getString("tenHocSinh"));
        inforCheckOut.setBirthdayBaby(rs.getString("ngaySinhHocSinh")); 
        inforCheckOut.setBabyClass(rs.getString("lophoc"));
        return inforCheckOut;
    }
    
}
