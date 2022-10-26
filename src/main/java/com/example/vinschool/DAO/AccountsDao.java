package com.example.vinschool.DAO;

import java.util.List;

import com.example.vinschool.Model.Accounts;

public interface AccountsDao {
    Accounts checkAccount(String username);
    int insertAccount(Accounts accounts);
    List<Accounts> showList();
}
