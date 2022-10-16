package com.example.vinschool.Service.Imp;

import com.example.vinschool.DAO.DanhGiaDao;
import com.example.vinschool.Model.DanhGia;
import com.example.vinschool.Service.DanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhGiaServiceImp implements DanhGiaService {
    @Autowired
    DanhGiaDao danhGiaDao;

    @Override
    public int insertDanhGia(DanhGia danhGia) {
        return danhGiaDao.insertDanhGia(danhGia);
    }

    @Override
    public List<DanhGia> showList(int limit) {
        return danhGiaDao.showList(limit);
    }

    @Override
    public int xoaDanhGia(int idKH) {
        return danhGiaDao.xoaDanhGia(idKH);
    }

    @Override
    public List<DanhGia> find(String key) {
        return danhGiaDao.find(key);
    }
}
