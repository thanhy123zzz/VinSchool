package com.example.vinschool.DAO;

import java.util.List;

import com.example.vinschool.Model.AdmissionTicket;

public interface AdmissionTiketDAO {
    int addAdmissionTicket(AdmissionTicket AdmissionTicket);
    Boolean checkIDCustomers(int id);
    List<AdmissionTicket> showList();
    List<AdmissionTicket> FindList(int id);
}
