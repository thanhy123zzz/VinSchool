package com.example.vinschool.Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.vinschool.Model.AdmissionTicket;

public class AdmissionTicketMapper implements RowMapper<AdmissionTicket>{

    @Override
    public AdmissionTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
        AdmissionTicket AdmissionTicket = new AdmissionTicket();
        AdmissionTicket.setIdTicket(rs.getInt("idPhieu"));
        AdmissionTicket.setFullname(rs.getString("tenPhuHuynh"));
        AdmissionTicket.setPhonenumber(rs.getString("phone"));
        AdmissionTicket.setAddress(rs.getString("DiaChi"));
        AdmissionTicket.setWokingAt(rs.getString("DonViCongTac"));
        AdmissionTicket.setEmail(rs.getString("email"));
        AdmissionTicket.setFullnameBaby(rs.getString("tenHocSinh"));
        AdmissionTicket.setBirthdayBaby(rs.getString("ngaySinhHocSinh"));
        AdmissionTicket.setBabyClass(rs.getString("lophoc"));
        AdmissionTicket.setNote(rs.getString("note"));
        AdmissionTicket.setId(rs.getInt("idkh"));
        return AdmissionTicket;
    }
    
}
