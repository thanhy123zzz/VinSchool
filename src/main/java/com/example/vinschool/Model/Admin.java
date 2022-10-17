package com.example.vinschool.Model;

public class Admin extends Customer{

    public Admin() {
    }
    public Admin(int id, String fullname, String birthday, String citizenId, String phonenumber, String email,
            Boolean gender,
            String username) {
        super(id, fullname, birthday, citizenId, phonenumber, email, gender, username);
    }
    
}
