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
    public int addCustomer(Customer customer){
        String sql = "INSERT INTO `vinschool`.`khachhang` (`Ten`, `NgaySinh`, `CCCD`, `Phone`, `Email`, `GioiTinh`, `TaiKhoan`) VALUES (?,?,?,?,?,?,'khachhang123');";
        return jdbctemplate.update(sql, new Object[] {customer.getFullname(),customer.getBirthday(),customer.getCitizenId(),
        customer.getPhonenumber(),customer.getEmail(),customer.getGender(),customer.getTaiKhoan()});
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
}
