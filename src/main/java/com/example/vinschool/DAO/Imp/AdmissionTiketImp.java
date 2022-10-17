package com.example.vinschool.DAO.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.vinschool.DAO.AdmissionTiketDAO;
import com.example.vinschool.Model.AdmissionTicket;
import com.example.vinschool.Model.Mapper.AdmissionTicketMapper;

@Repository
public class AdmissionTiketImp implements AdmissionTiketDAO {

    @Autowired
    JdbcTemplate jdbctemplate;

    @Override
    public int addAdmissionTicket(AdmissionTicket AdmissionTicket) {
        String sql = "INSERT INTO `vinschool`.`phieudangky`(`tenPhuHuynh`,`phone`,`DiaChi`,`DonViCongTac`,`email`,`tenHocSinh`,`ngaySinhHocSinh`,`lophoc`,`note`,`idkh`) VALUES(?,?,?,?,?,?,?,?,?,?);";
        return jdbctemplate.update(sql,
                new Object[] { AdmissionTicket.getFullname(), AdmissionTicket.getPhonenumber(),
                        AdmissionTicket.getWokingAt(),
                        AdmissionTicket.getAddress(), AdmissionTicket.getEmail(), AdmissionTicket.getFullnameBaby(),
                        AdmissionTicket.getBirthdayBaby(),
                        AdmissionTicket.getBabyClass(), AdmissionTicket.getNote(),AdmissionTicket.getId() });
    }

    @Override
    public List<AdmissionTicket> checkIDCustomers(int id) {
        String sql = "SELECT `idPhieu`,`tenPhuHuynh`,pdk.`phone`,`DiaChi`,`DonViCongTac`,pdk.`email`,`tenHocSinh`,`ngaySinhHocSinh`,`lophoc`,`note`,pdk.`idkh` FROM phieudangky pdk join khachhang kh on kh.IDKH = pdk.idkh where kh.IDKH = "+ id + "";
                return jdbctemplate.query(sql, new AdmissionTicketMapper());
    }

}
