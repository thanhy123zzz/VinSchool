package com.example.vinschool.DAO.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.vinschool.DAO.HocPhiDAO;
import com.example.vinschool.Model.HocPhi;
import com.example.vinschool.Model.Mapper.HocPhiMapper;

@Repository
public class HocPhiImp implements HocPhiDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<HocPhi> showList() {
        String sql = "SELECT * FROM `vinschool`.`hocphi`;";
        List<HocPhi> list = jdbcTemplate.query(sql, new HocPhiMapper());
        return list;
    }
}