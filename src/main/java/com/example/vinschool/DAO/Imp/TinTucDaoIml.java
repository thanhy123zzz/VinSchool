package com.example.vinschool.DAO.Imp;

import com.example.vinschool.DAO.TinTucDao;
import com.example.vinschool.Model.Mapper.TinTucMapper;
import com.example.vinschool.Model.TinTuc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class TinTucDaoIml implements TinTucDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insertTin(TinTuc tinTuc) throws IOException {
        String query = "insert into tintuc(`NgayTao`,`title`,`subtitle`,`overview`,`idADMIN`,`image`) values(?,?,?,?,?,?)";
        byte[] photoBytes = tinTuc.getPhoto().getBytes();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        int kq = jdbcTemplate.update(query,new Object[] {date,tinTuc.getTitle(),tinTuc.getSubTitle(),tinTuc.getOverview(),tinTuc.getIdADMIN(),photoBytes});
        return kq;
    }

    @Override
    public List<TinTuc> showList(int limit) {
        String query;
        if(limit==0) {
             query = "select*from tintuc order by NgayTao desc";
        }else{
            query = "select*from tintuc order by NgayTao desc limit "+limit;
        }
        List<TinTuc> list = jdbcTemplate.query(query, new TinTucMapper());
        return list;
    }

    @Override
    public TinTuc findTin(int id) {
        String query = "select*from tintuc where idTin="+id;
        List<TinTuc> list = jdbcTemplate.query(query, new TinTucMapper());
        return list.get(0);
    }

    @Override
    public int xoaTin(int idTin) {
        String query = "delete from tintuc where idTin = " + idTin;
        int kq = jdbcTemplate.update(query);
        return kq;
    }

    @Override
    public int suaTin(TinTuc tinTuc) throws IOException {
        String query;
        byte[] photoBytes;
        int kq;
        if(!tinTuc.getPhoto().isEmpty()){
            photoBytes = tinTuc.getPhoto().getBytes();
            query = "update tintuc set title = ?, subtitle =?,overview =?, image = ? where idTin =?;";
            kq = jdbcTemplate.update(query,new Object[]{tinTuc.getTitle(),tinTuc.getSubTitle(),tinTuc.getOverview(),photoBytes,tinTuc.getIdTin()});
        }
        else {
            query = "update tintuc set title = ?, subtitle =?,overview =? where idTin =?;";
            kq = jdbcTemplate.update(query,new Object[]{tinTuc.getTitle(),tinTuc.getSubTitle(),tinTuc.getOverview(),tinTuc.getIdTin()});
        }
        return kq;
    }

}
