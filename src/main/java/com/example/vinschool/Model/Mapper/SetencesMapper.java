package com.example.vinschool.Model.Mapper;

import com.example.vinschool.Model.Setences;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SetencesMapper implements RowMapper<Setences> {
    @Override
    public Setences mapRow(ResultSet rs, int rowNum) throws SQLException {
        Setences cs = new Setences();
        cs.setIdTin(rs.getInt("idTin"));
        cs.setSoHeader(rs.getInt("soHeader"));
        cs.setContent(rs.getString("content"));
        cs.setSo(rs.getInt("so"));
        return cs;
    }
}
