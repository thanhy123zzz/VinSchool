package com.example.vinschool.DAO;

import com.example.vinschool.Model.Accounts;

public interface AccountsDao {
    Accounts checkAccount(String username);
}
