package com.example.vinschool.Service;

import java.util.List;

import com.example.vinschool.Model.InforCheckOut;

public interface InforCheckOutService {
    int addThongtinthanhtoan(InforCheckOut inforCheckOut);
    List<InforCheckOut> findThongTinThanhToanByIdCus(int idCustomer);
    // List<InforCheckOut> CheckThongTinThanhToanByIdCus(int idCustomer);
    List<InforCheckOut> showList();
    Boolean CheckThongTinThanhToanByIdCus(int idCustomer);
    
}
