package com.example.vinschool.Service.Imp;

import com.example.vinschool.DAO.AccountsDao;
import com.example.vinschool.Model.Accounts;
import com.example.vinschool.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements ManagerService {
    @Autowired
    private AccountsDao accountsDao;
    @Override
    public Accounts checkAccount(Accounts accounts) {
        return accountsDao.checkAccount(accounts);
    }
}
