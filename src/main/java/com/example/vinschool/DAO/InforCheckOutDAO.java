package com.example.vinschool.DAO;

import java.util.List;

import com.example.vinschool.Model.InforCheckOut;

public interface InforCheckOutDAO {
    int addThongtinthanhtoan(InforCheckOut inforCheckOut);
    List<InforCheckOut> findThongTinThanhToanByIdCus(int idCustomer);
    List<InforCheckOut> showList();
    Boolean CheckThongTinThanhToanByIdCus(int idCustomer);
    
}
