package com.example.vinschool.DAO;

import com.example.vinschool.Model.DanhGia;

import java.util.List;

public interface DanhGiaDao {
    int insertDanhGia(DanhGia danhGia);
    List<DanhGia> showList(int limit);

    int xoaDanhGia(int idKH);

    List<DanhGia> find(String key);
}
