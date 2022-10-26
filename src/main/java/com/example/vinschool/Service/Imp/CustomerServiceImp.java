package com.example.vinschool.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vinschool.DAO.CustomerDAO;
import com.example.vinschool.Model.Customer;
import com.example.vinschool.Service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> showList(){
        return customerDAO.showList();
    }

    @Override
    public int addCustomer(Customer customer){
        return customerDAO.addCustomer(customer);
    }

    @Override
    public int editCustomer(Customer customer){
        return customerDAO.editCustomer(customer);
    }

    @Override
    public int removeCustomer(int id){
        return customerDAO.removeCustomer(id);
    }

    @Override
    public Customer inforCT(String taikhoan) {
        return customerDAO.infoCustomer(taikhoan);
    }

    @Override
    public Customer inforCT(int idkh) {
        return customerDAO.infoCustomer(idkh);
    }

    @Override
    public Customer findIDCustomers(String TaiKhoan){
        return customerDAO.findIDCustomers(TaiKhoan).get(0);
    }

    @Override
    public List<Customer> checkIDCustomers(int id){
        return customerDAO.checkIDCustomers(id);
    }

    @Override
    public int addNullCustomer(Customer customer){
        return customerDAO.addNullCustomer(customer);
    }
}
