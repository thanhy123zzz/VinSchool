package com.example.vinschool.Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.example.vinschool.Model.Customer;

public class CustomerMapper implements RowMapper<Customer>{

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer cus = new Customer(); //IDNV
        cus.setId(rs.getInt("IDKH"));
        cus.setFullname(rs.getString("Ten"));
        cus.setBirthday(rs.getString("NgaySinh"));
        cus.setCitizenId(rs.getString("CCCD"));
        cus.setPhonenumber(rs.getString("Phone"));
        cus.setEmail(rs.getString("Email"));
        cus.setGender(rs.getString("GioiTinh"));
        cus.setTaiKhoan("TaiKhoan");
        return cus;
    }
}
