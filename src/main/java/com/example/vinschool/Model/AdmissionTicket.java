package com.example.vinschool.Model;

public class AdmissionTicket extends Customer{
    private int idTicket;
    private String wokingAt;
    private String address;
    private String fullnameBaby;
    private String birthdayBaby;
    private String note;
    private String babyClass;


    public AdmissionTicket(int idCus, String fullname, String email,String phone,int idTicket, String wokingAt, String address, String fullnameBaby, String birthdayBaby, String note,String babyClass) {
        super(idCus, fullname, email, phone);
        this.idTicket = idTicket;
        this.wokingAt = wokingAt;
        this.address = address;
        this.fullnameBaby = fullnameBaby;
        this.birthdayBaby = birthdayBaby;
        this.note = note;
        this.babyClass = babyClass;
    }

    @Override
    public String toString() {
        return "{" +
            " idTicket='" + getIdTicket() + "'" +
            ", wokingAt='" + getWokingAt() + "'" +
            ", address='" + getAddress() + "'" +
            ", fullnameBaby='" + getFullnameBaby() + "'" +
            ", birthdayBaby='" + getBirthdayBaby() + "'" +
            ", note='" + getNote() + "'" +
            ", babyClass='" + getBabyClass() + "'" +
            "}";
    }

    public AdmissionTicket() {
    }

    public AdmissionTicket(int idTiket,String none){
        this.idTicket = idTiket;
        /* None khong truyen*/
    }

    public AdmissionTicket(int idCus){
        super(idCus);
    }


    public String getBabyClass() {
        return this.babyClass;
    }

    public void setBabyClass(String babyClass) {
        this.babyClass = babyClass;
    }

    public int getIdTicket() {
        return this.idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getWokingAt() {
        return this.wokingAt;
    }

    public void setWokingAt(String wokingAt) {
        this.wokingAt = wokingAt;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullnameBaby() {
        return this.fullnameBaby;
    }

    public void setFullnameBaby(String fullnameBaby) {
        this.fullnameBaby = fullnameBaby;
    }

    public String getBirthdayBaby() {
        return this.birthdayBaby;
    }

    public void setBirthdayBaby(String birthdayBaby) {
        this.birthdayBaby = birthdayBaby;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }



}
