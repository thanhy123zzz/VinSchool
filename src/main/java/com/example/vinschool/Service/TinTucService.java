package com.example.vinschool.Service;

import com.example.vinschool.Model.TinTuc;

import java.io.IOException;
import java.util.List;

public interface TinTucService {
    int insertTin(TinTuc tinTuc) throws IOException;

    List<TinTuc> showList(int limit);

    TinTuc findTin(int id);

    int xoaTin(int idTin);

    int suaTin(TinTuc tinTuc) throws IOException;
}
