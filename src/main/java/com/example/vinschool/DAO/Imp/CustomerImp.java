package com.example.vinschool.DAO.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.vinschool.DAO.CustomerDAO;
import com.example.vinschool.Model.Customer;
import com.example.vinschool.Model.Mapper.CustomerMapper;

@Repository
public class CustomerImp implements CustomerDAO {

    @Autowired
    JdbcTemplate jdbctemplate;

    @Override
    public List<Customer> showList() {
        String sql = "SELECT * FROM vinschool.khachhang";
        List<Customer> list = jdbctemplate.query(sql, new CustomerMapper());
        return list;
    }

    @Override
    public int addCustomer(Customer customer) {
        String sql = "INSERT INTO `vinschool`.`khachhang` (`Ten`, `NgaySinh`, `CCCD`, `Phone`, `Email`, `GioiTinh`, `TaiKhoan`) VALUES (?,?,?,?,?,?,?);";
        return jdbctemplate.update(sql,
                new Object[] { customer.getFullname(), customer.getBirthday(), customer.getCitizenId(),
                        customer.getPhonenumber(), customer.getEmail(), customer.getGender(), customer.getTaiKhoan() });
    }

    @Override
    public int addNullCustomer(Customer customer){
        String sql = "INSERT INTO `vinschool`.`khachhang` (`Ten`,`TaiKhoan`) VALUES (?,?);";
        return jdbctemplate.update(sql, new Object[] {customer.getFullname(),customer.getTaiKhoan()});
    }

    @Override
    public int editCustomer(Customer customer){
        String sql = "UPDATE `vinschool`.`khachhang` SET  `Ten` = ?, `NgaySinh` = ?, `CCCD` = ?, `Phone` = ?, `Email` = ?, `GioiTinh` = ?, `TaiKhoan` = ? WHERE `IDNV` = ?";
        return jdbctemplate.update(sql, new Object[] {customer.getFullname(),customer.getBirthday(),customer.getCitizenId(),
        customer.getPhonenumber(),customer.getEmail(),customer.getGender(),customer.getTaiKhoan(),customer.getId()});
    }

    @Override
    public int removeCustomer(int id) {
        String sql = "DELETE from `vinschool`.`khachhang` WHERE IDKH = ?";
        return jdbctemplate.update(sql);
    }

    @Override
    public List<Customer> findIDCustomers(String TaiKhoan) {
        String sql = "Select IDKH,Ten,NgaySinh,CCCD,Phone,Email,GioiTinh,ac.TaiKhoan from accounts ac join khachhang kh on ac.TaiKhoan = kh.TaiKhoan Where ac.TaiKhoan = '"
                + TaiKhoan + "';";
        return jdbctemplate.query(sql, new CustomerMapper());
    } 

    @Override
    public List<Customer> checkIDCustomers(int id) {
        String sql = "SELECT pdk.IDKH,Ten,NgaySinh,CCCD,kh.Phone,kh.Email,GioiTinh,kh.TaiKhoan FROM phieudangky pdk join khachhang kh on kh.IDKH = pdk.idkh where pdk.IDKH = " + id + ";";
        return jdbctemplate.query(sql, new CustomerMapper());
    }
    @Override
    public Customer infoCustomer(String taiKhoan) {
        String query = "select*from khachhang where TaiKhoan ='"+taiKhoan+"'";
        List<Customer> list = jdbctemplate.query(query,new CustomerMapper());
        return list.get(0);
    }

    @Override
    public Customer infoCustomer(int idkh) {
        String query = "select*from khachhang where IDKH ="+idkh;
        List<Customer> list = jdbctemplate.query(query,new CustomerMapper());
        return list.get(0);
    }
}
