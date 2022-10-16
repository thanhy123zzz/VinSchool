package com.example.vinschool.Model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TinTuc {
    private int idTin;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date NgayTao;
    private String title;
    private String subTitle;
    private String overview;
    private int idNV;
    private int idADMIN;
    private Blob image;

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    private MultipartFile photo;
    public TinTuc() {
    }

    public int getIdTin() {
        return idTin;
    }

    public void setIdTin(int idTin) {
        this.idTin = idTin;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date ngayTao) {
        NgayTao = ngayTao;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public int getIdADMIN() {
        return idADMIN;
    }

    public void setIdADMIN(int idADMIN) {
        this.idADMIN = idADMIN;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
