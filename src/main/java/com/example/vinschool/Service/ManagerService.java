package com.example.vinschool.Service;

import com.example.vinschool.Model.Accounts;

public interface ManagerService {
    int insertAccount(Accounts accounts);

    boolean checkAccount(String userName);
}
