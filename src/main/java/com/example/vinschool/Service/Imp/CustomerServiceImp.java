package com.example.vinschool.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
}
