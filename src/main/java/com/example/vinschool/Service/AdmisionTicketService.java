package com.example.vinschool.Service;

import java.util.List;

import com.example.vinschool.Model.AdmissionTicket;

public interface AdmisionTicketService {
    int addAdmissionTicket(AdmissionTicket AdmissionTicket);
    List<AdmissionTicket> checkIDCustomers(int id);
}
