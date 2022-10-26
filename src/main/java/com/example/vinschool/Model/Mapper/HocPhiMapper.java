package com.example.vinschool.Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.vinschool.Model.HocPhi;

public class HocPhiMapper implements RowMapper<HocPhi>{
    @Override
    public HocPhi mapRow(ResultSet rs, int rowNum) throws SQLException {
        HocPhi hocPhi = new HocPhi();
        hocPhi.setIdHP(rs.getString("idHP"));
        hocPhi.setTenhocphi(rs.getString("TenHocPhi"));
        hocPhi.setLoaihocphi(rs.getString("loaiHocPhi"));
        hocPhi.setTienhocphi(rs.getDouble("TienHocPhi"));
        return hocPhi;
    }
}
