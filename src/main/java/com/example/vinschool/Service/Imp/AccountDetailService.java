package com.example.vinschool.Service.Imp;

import com.example.vinschool.DAO.AccountsDao;
import com.example.vinschool.DAO.TinTucDao;
import com.example.vinschool.Model.Accounts;
import com.example.vinschool.Model.TinTuc;
import com.example.vinschool.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountDetailService implements UserDetailsService, ManagerService {
    @Autowired
    private AccountsDao accountsDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Accounts accounts = accountsDao.checkAccount(username);

        if(accounts==null){
            new UsernameNotFoundException("Loign fail!");
        }
        else {

            List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
            GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
            grantList.add(authority);
            UserDetails user = User
                    .withUsername(accounts.getTaiKhoan())
                    .password(accounts.getMatKhau())
                    .roles(accounts.getIDrole())
                    .build();
            return user;
        }
        return null;
    }

    @Override
    public int insertAccount(Accounts accounts) {
        return accountsDao.insertAccount(accounts);
    }

    @Override
    public boolean checkAccount(String userName) {
        return accountsDao.checkAccount(userName) == null;
    }
}
