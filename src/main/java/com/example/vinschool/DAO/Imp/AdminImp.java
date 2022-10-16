package com.example.vinschool.DAO.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.vinschool.DAO.AdminDAO;
import com.example.vinschool.Model.Admin;
import com.example.vinschool.Model.Mapper.AdminMapper;


@Repository
public class AdminImp implements AdminDAO{
    
    @Autowired
    JdbcTemplate jdbctemplate;

    @Override
    public List<Admin> showList() {
        String sql = "SELECT * FROM vinschool.admin";
        List<Admin> list = jdbctemplate.query(sql, new AdminMapper());
        return list;
    }

    @Override
    public int addAdmin(Admin Admin){
        String sql = "INSERT INTO `vinschool`.`admin` (`Ten`, `NgaySinh`, `CCCD`, `Phone`, `Email`, `GioiTinh`, `TaiKhoan`) VALUES (?,?,?,?,?,?,'admin123');";
        return jdbctemplate.update(sql, new Object[] {Admin.getFullname(),Admin.getBirthday(),Admin.getCitizenId(),
        Admin.getPhonenumber(),Admin.getEmail(),Admin.getGender(),Admin.getTaiKhoan()});
    }

    @Override
    public int editAdmin(Admin Admin){
        String sql = "UPDATE `vinschool`.`admin` SET  `Ten` = ?, `NgaySinh` = ?, `CCCD` = ?, `Phone` = ?, `Email` = ?, `GioiTinh` = ?, `TaiKhoan` = ? WHERE `IDNV` = ?";
        return jdbctemplate.update(sql, new Object[] {Admin.getFullname(),Admin.getBirthday(),Admin.getCitizenId(),
        Admin.getPhonenumber(),Admin.getEmail(),Admin.getGender(),Admin.getTaiKhoan(),Admin.getId()});
    }
    @Override
	public int removeAdmin(int id) {
		String sql = "DELETE from `vinschool`.`admin` WHERE IDADMIN = ?";
		return jdbctemplate.update(sql);
	}

    @Override
    public Admin showAdmin(String TaiKhoan) {
        String sql = "SELECT * FROM admin where TaiKhoan='"+TaiKhoan+"'";
        List<Admin> list = jdbctemplate.query(sql, new AdminMapper());
        if(list.size()==1) {
            return list.get(0);
        }
        else return null;
    }
}
