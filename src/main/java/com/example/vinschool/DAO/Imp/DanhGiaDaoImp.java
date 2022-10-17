package com.example.vinschool.DAO.Imp;

import com.example.vinschool.DAO.DanhGiaDao;
import com.example.vinschool.Model.DanhGia;
import com.example.vinschool.Model.Mapper.DanhGiaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DanhGiaDaoImp implements DanhGiaDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insertDanhGia(DanhGia danhGia) {
        String query = "insert into danhgia(`idKH`,`ngaydanhgia`,`rate`,`content`) values(?,?,?,?);";
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return jdbcTemplate.update(query,new Object[]{danhGia.getIdKH(),date,danhGia.getRate(),danhGia.getContent()});
    }

    @Override
    public List<DanhGia> showList(int limit) {
        String query = "select*from danhgia,khachhang where danhgia.idKH = khachhang.IDKH order by ngaydanhgia";
        return jdbcTemplate.query(query,new DanhGiaMapper());
    }

    @Override
    public int xoaDanhGia(int idKH) {
        String query = "delete from danhgia where idKH = " + idKH;
        return jdbcTemplate.update(query);
    }

    @Override
    public List<DanhGia> find(String key) {
        String query = "select*from danhgia,khachhang where danhgia.idKH = khachhang.IDKH and concat_ws(' ',danhgia.idKH,danhgia.content,rate,khachhang.Ten) like '%"+key+"%';";
        return jdbcTemplate.query(query,new DanhGiaMapper());
    }

}
