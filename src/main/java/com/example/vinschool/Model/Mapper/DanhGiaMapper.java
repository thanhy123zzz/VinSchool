package com.example.vinschool.Model.Mapper;

import com.example.vinschool.Model.DanhGia;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DanhGiaMapper implements RowMapper<DanhGia> {
    @Override
    public DanhGia mapRow(ResultSet rs, int rowNum) throws SQLException {
        DanhGia danhGia = new DanhGia();
        danhGia.setNgaydanhgia(rs.getDate("ngaydanhgia"));
        danhGia.setContent(rs.getString("content"));
        danhGia.setIdKH(rs.getInt("idKH"));
        danhGia.setRate(rs.getInt("rate"));
        danhGia.setTen(rs.getString("Ten"));
        return danhGia;
    }
}
