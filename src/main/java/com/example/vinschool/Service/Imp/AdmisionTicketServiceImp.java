package com.example.vinschool.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vinschool.DAO.AdmissionTiketDAO;
import com.example.vinschool.Model.AdmissionTicket;
import com.example.vinschool.Service.AdmisionTicketService;

@Service
public class AdmisionTicketServiceImp implements AdmisionTicketService{
    
    @Autowired
    AdmissionTiketDAO admissionTiketDAO;

    @Override
    public int addAdmissionTicket(AdmissionTicket AdmissionTicket){
        return admissionTiketDAO.addAdmissionTicket(AdmissionTicket);
    }

    @Override
    public Boolean checkIDCustomers(int id) {
        return admissionTiketDAO.checkIDCustomers(id);
    }

    @Override
    public List<AdmissionTicket> showList(){
        return admissionTiketDAO.showList();
    }

    @Override
    public List<AdmissionTicket> FindList(int id){
        return admissionTiketDAO.FindList(id);
    }
}
