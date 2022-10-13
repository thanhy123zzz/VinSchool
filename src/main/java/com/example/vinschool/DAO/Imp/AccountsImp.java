package com.example.vinschool.DAO.Imp;

import com.example.vinschool.DAO.AccountsDao;
import com.example.vinschool.Model.Accounts;
import com.example.vinschool.Model.Mapper.AccountsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountsImp implements AccountsDao {

    @Autowired
    JdbcTemplate jdbctemplate;

    @Override
    public Accounts checkAccount(String username) {
        String query = "select * from accounts where TaiKhoan = '"+username+"'";
        List<Accounts> list = new ArrayList<Accounts>();
        list = jdbctemplate.query(query,new AccountsMapper());
        if(list.size()==1)return list.get(0);
        else return null;
    }
}
