package com.example.vinschool.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vinschool.DAO.InforCheckOutDAO;
import com.example.vinschool.Model.InforCheckOut;
import com.example.vinschool.Service.InforCheckOutService;

@Service
public class InforCheckOutServiceImp implements InforCheckOutService {

    @Autowired
    InforCheckOutDAO inforCheckOutDAO;

    @Override
    public int addThongtinthanhtoan(InforCheckOut inforCheckOut) {
        return inforCheckOutDAO.addThongtinthanhtoan(inforCheckOut);
    }

    @Override
    public List<InforCheckOut> findThongTinThanhToanByIdCus(int idCustomer){
        List<InforCheckOut> list =  inforCheckOutDAO.findThongTinThanhToanByIdCus(idCustomer);
        if(list.size()>0){
            return list;
        }else{
            return null;
        }
    }

    // @Override
    // public List<InforCheckOut> CheckThongTinThanhToanByIdCus(int idCustomer){
    //     return inforCheckOutDAO.findThongTinThanhToanByIdCus(idCustomer);
    // }

    @Override
    public List<InforCheckOut> showList(){
        return inforCheckOutDAO.showList();
    }

    @Override
    public Boolean CheckThongTinThanhToanByIdCus(int idCustomer){
        return inforCheckOutDAO.CheckThongTinThanhToanByIdCus(idCustomer);
    }

}
