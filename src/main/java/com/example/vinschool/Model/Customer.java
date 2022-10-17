package com.example.vinschool.Model;

public class Customer extends Accounts {
    private int id;
    private String fullname;
    private String birthday;
    private String citizenId;
    private String phonenumber;
    private String email;
    private boolean gender;

    public Customer() {
    }

    public Customer(int id,String fullname, String birthday, String citizenId, String phonenumber,String email, boolean gender,
            String username) {
        super(username);
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.citizenId = citizenId;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.email = email;
    }

    public Customer(int idCus, String fullname, String email,String phone){
        this.id = idCus;
        this.fullname = fullname;
        this.email = email;
        this.phonenumber = phone;
    }
    public Customer(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCitizenId() {
        return this.citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public boolean isGender() {
        return this.gender;
    }

    public boolean getGender() {
        return this.gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fullname='" + getFullname() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", citizenId='" + getCitizenId() + "'" +
            ", phonenumber='" + getPhonenumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", gender='" + isGender() + "'" +
            "}";
    }


}
