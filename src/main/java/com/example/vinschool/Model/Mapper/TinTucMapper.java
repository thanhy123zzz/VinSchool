package com.example.vinschool.Model.Mapper;

import com.example.vinschool.Model.TinTuc;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TinTucMapper implements RowMapper<TinTuc> {
    @Override
    public TinTuc mapRow(ResultSet rs, int rowNum) throws SQLException {
        TinTuc tinTuc = new TinTuc();
        tinTuc.setIdTin(rs.getInt("idTin"));
        tinTuc.setIdADMIN(rs.getInt("idADMIN"));
        tinTuc.setIdNV(rs.getInt("idNV"));
        tinTuc.setNgayTao(rs.getDate("NgayTao"));
        tinTuc.setTitle(rs.getString("title"));
        tinTuc.setSubTitle(rs.getString("subtitle"));
        tinTuc.setOverview(rs.getString("overview"));
        tinTuc.setImage(rs.getBlob("image"));
        return tinTuc;
    }
}
