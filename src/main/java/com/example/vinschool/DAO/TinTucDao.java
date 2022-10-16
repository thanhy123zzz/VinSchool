package com.example.vinschool.DAO;

import com.example.vinschool.Model.TinTuc;

import java.io.IOException;
import java.util.List;

public interface TinTucDao {
    int insertTin(TinTuc tinTuc) throws IOException;

    List<TinTuc> showList(int limit);

    TinTuc findTin(int id);

    int xoaTin(int idTin);

    int suaTin(TinTuc tinTuc) throws IOException;
}
