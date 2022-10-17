package com.example.vinschool.Service;

import java.util.List;

import com.example.vinschool.Model.Customer;

public interface CustomerService {
    List<Customer> showList();
    int addCustomer(Customer customer);
    int editCustomer(Customer customer);
    int removeCustomer(int id);
    Customer findIDCustomers(String TaiKhoan);
    List<Customer> checkIDCustomers(int id);

    Customer inforCT(String taikhoan);

    Customer inforCT(int idkh);
}
