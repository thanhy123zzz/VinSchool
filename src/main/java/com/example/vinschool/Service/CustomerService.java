package com.example.vinschool.Service;

import java.util.List;

import com.example.vinschool.Model.Customer;

public interface CustomerService {
    List<Customer> showList();
    int addCustomer(Customer customer);
    int editCustomer(Customer customer);
    int removeCustomer(int id);

}
