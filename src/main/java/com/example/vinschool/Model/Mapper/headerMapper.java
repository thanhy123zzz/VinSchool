package com.example.vinschool.Model.Mapper;

import com.example.vinschool.Model.header;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class headerMapper implements RowMapper<header> {
    @Override
    public header mapRow(ResultSet rs, int rowNum) throws SQLException {
        header header = new header();
        header.setIdTin(rs.getInt("idTin"));
        header.setTenHeader(rs.getString("tenHeader"));
        header.setSo(rs.getInt("so"));
        return header;
    }
}
