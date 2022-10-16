package com.example.vinschool.Service;

import com.example.vinschool.Model.Accounts;
import com.example.vinschool.Model.TinTuc;

public interface ManagerService {
    int insertAccount(Accounts accounts);

    boolean checkAccount(String userName);
}
