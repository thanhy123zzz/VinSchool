package com.example.vinschool.Model;

import java.io.Serializable;

public class Accounts implements Serializable {
    private String TaiKhoan;
    private String MatKhau;
    private String IDrole;

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getIDrole() {
        return IDrole;
    }

    public void setIDrole(String IDrole) {
        this.IDrole = IDrole;
    }

    public Accounts(String taiKhoan, String matKhau) {
        TaiKhoan = taiKhoan;
        MatKhau = matKhau;
    }
    public Accounts() {
    }
}
