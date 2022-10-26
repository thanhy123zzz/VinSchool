package com.example.vinschool.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vinschool.DAO.HocPhiDAO;
import com.example.vinschool.Model.HocPhi;
import com.example.vinschool.Service.HocPhiService;

@Service
public class HocPhiServiceImp implements HocPhiService{
    @Autowired
    HocPhiDAO hocPhiDAO;

    @Override
    public List<HocPhi> showList(){
        return hocPhiDAO.showList();
    }
}
