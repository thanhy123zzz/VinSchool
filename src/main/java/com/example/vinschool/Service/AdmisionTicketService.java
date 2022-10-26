package com.example.vinschool.Service;

import java.util.List;

import com.example.vinschool.Model.AdmissionTicket;

public interface AdmisionTicketService {
    int addAdmissionTicket(AdmissionTicket AdmissionTicket);
    Boolean checkIDCustomers(int id);
    List<AdmissionTicket> showList();
    List<AdmissionTicket> FindList(int id);
}
