package com.example.vinschool.Model;

public class Staff extends Customer {
    private String wokingday;

    public Staff() {
    }

    public Staff(int id, String fullname, String birthday, String citizenId, String phonenumber, String email,
            String gender,
            String username,String wokingday) {
        super(id, fullname, birthday, citizenId, phonenumber, email, gender, username);
        this.wokingday = wokingday;
    }


    public String getWokingday() {
        return this.wokingday;
    }

    public void setWokingday(String wokingday) {
        this.wokingday = wokingday;
    }


}
