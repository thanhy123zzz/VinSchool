package com.example.vinschool.Service;

import com.example.vinschool.DAO.DanhGiaDao;
import com.example.vinschool.Model.DanhGia;

import java.util.List;

public interface DanhGiaService {
    int insertDanhGia(DanhGia danhGia);
    List<DanhGia> showList(int limit);

    int xoaDanhGia(int idKH);

    List<DanhGia> find(String key);
}
