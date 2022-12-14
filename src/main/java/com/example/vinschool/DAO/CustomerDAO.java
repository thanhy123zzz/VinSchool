package com.example.vinschool.DAO;

import java.util.List;

import com.example.vinschool.Model.Customer;

public interface CustomerDAO {
    List<Customer> showList();
    int addCustomer(Customer customer);
    int editCustomer(Customer customer);
    int removeCustomer(int id);
    Customer infoCustomer(String taiKhoan);
    Customer infoCustomer(int idkh);
    List<Customer> findIDCustomers(String TaiKhoan);
    List<Customer> checkIDCustomers(int id);
    int addNullCustomer(Customer customer);

}
