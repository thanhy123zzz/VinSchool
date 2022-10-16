package com.example.vinschool.Service.Imp;

import com.example.vinschool.DAO.TinTucDao;
import com.example.vinschool.Model.TinTuc;
import com.example.vinschool.Service.TinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TinServiceImp implements TinTucService {

    @Autowired
    TinTucDao tinTucDao;


    @Override
    public int insertTin(TinTuc tinTuc) throws IOException {
        return tinTucDao.insertTin(tinTuc);
    }

    @Override
    public List<TinTuc> showList(int limit) {
        return tinTucDao.showList(limit);
    }

    @Override
    public TinTuc findTin(int id) {
        return tinTucDao.findTin(id);
    }

    @Override
    public int xoaTin(int idTin) {
        return tinTucDao.xoaTin(idTin);
    }

    @Override
    public int suaTin(TinTuc tinTuc) throws IOException {
        return tinTucDao.suaTin(tinTuc);
    }
}
