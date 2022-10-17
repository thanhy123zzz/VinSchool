package com.example.vinschool.DAO;

import java.util.List;

import com.example.vinschool.Model.AdmissionTicket;

public interface AdmissionTiketDAO {
    int addAdmissionTicket(AdmissionTicket AdmissionTicket);
    List<AdmissionTicket> checkIDCustomers(int id);
}
