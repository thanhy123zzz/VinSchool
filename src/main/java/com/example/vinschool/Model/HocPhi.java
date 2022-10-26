package com.example.vinschool.Model;

public class HocPhi {
    private String idHP;
    private String tenhocphi;
    private String loaihocphi;
    private double tienhocphi;

    public HocPhi() {
    }

    public HocPhi(String idHP) {
        this.idHP = idHP;
    }

    public HocPhi(String idHP, String tenhocphi, String loaihocphi, double tienhocphi) {
        this.idHP = idHP;
        this.tenhocphi = tenhocphi;
        this.loaihocphi = loaihocphi;
        this.tienhocphi = tienhocphi;
    }


    public String getIdHP() {
        return this.idHP;
    }

    public void setIdHP(String idHP) {
        this.idHP = idHP;
    }

    public String getTenhocphi() {
        return this.tenhocphi;
    }

    public void setTenhocphi(String tenhocphi) {
        this.tenhocphi = tenhocphi;
    }

    public String getLoaihocphi() {
        return this.loaihocphi;
    }

    public void setLoaihocphi(String loaihocphi) {
        this.loaihocphi = loaihocphi;
    }

    public double getTienhocphi() {
        return this.tienhocphi;
    }

    public void setTienhocphi(double tienhocphi) {
        this.tienhocphi = tienhocphi;
    }

}
