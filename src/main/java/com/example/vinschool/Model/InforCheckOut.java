package com.example.vinschool.Model;

public class InforCheckOut extends AdmissionTicket {
    private String idHP;
    private int idTT;
    private String tenchuthe;
    private String sotaikhoan;
    private String ngayhethan;
    private String ngaythanhtoan;
    private float thue;
    private double tongtien;


    public InforCheckOut(int idTicket,String idHP, int idTT, String tenchuthe, String sotaikhoan, String ngayhethan, String ngaythanhtoan,float thue, double tongtien) {
        super(idTicket,"");
        this.idHP = idHP;
        this.idTT = idTT;
        this.tenchuthe = tenchuthe;
        this.sotaikhoan = sotaikhoan;
        this.ngayhethan = ngayhethan;
        this.ngaythanhtoan = ngaythanhtoan;
        this.tongtien = tongtien;
        this.thue = thue;
    }

    

    public float getThue() {
        return this.thue;
    }

    public void setThue(float thue) {
        this.thue = thue;
    }


    public String getIdHP() {
        return this.idHP;
    }

    public void setIdHP(String idHP) {
        this.idHP = idHP;
    }

    public int getIdTT() {
        return this.idTT;
    }

    public void setIdTT(int idTT) {
        this.idTT = idTT;
    }
    
    public String getTenchuthe() {
        return this.tenchuthe;
    }

    public void setTenchuthe(String tenchuthe) {
        this.tenchuthe = tenchuthe;
    }

    public InforCheckOut() {
    }

    public String getSotaikhoan() {
        return this.sotaikhoan;
    }

    public void setSotaikhoan(String sotaikhoan) {
        this.sotaikhoan = sotaikhoan;
    }

    public String getNgayhethan() {
        return this.ngayhethan;
    }

    public void setNgayhethan(String ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public String getNgaythanhtoan() {
        return this.ngaythanhtoan;
    }

    public void setNgaythanhtoan(String ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }

    public double getTongtien() {
        return this.tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

}
