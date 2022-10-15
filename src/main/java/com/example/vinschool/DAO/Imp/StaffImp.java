package com.example.vinschool.DAO.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.vinschool.DAO.StaffDAO;
import com.example.vinschool.Model.Staff;
import com.example.vinschool.Model.Mapper.StaffMapper;

@Repository
public class StaffImp implements StaffDAO {

    @Autowired
    JdbcTemplate jdbctemplate;

    @Override
    public List<Staff> showList() {
        String sql = "SELECT * FROM vinschool.nhanvien";
        List<Staff> list = jdbctemplate.query(sql, new StaffMapper());
        return list;
    }
// INSERT INTO `vinschool`.`nhanvien`

    @Override
    public int addStaff(Staff Staff) {
        String sql = "INSERT INTO `vinschool`.`nhanvien` (`Ten`, `NgaySinh`, `CCCD`, `Phone`, `Email`, `GioiTinh`, `TaiKhoan`,'NgayBatDauLam') VALUES (?,?,?,?,?,?,'nhanvien',?);";
        return jdbctemplate.update(sql, new Object[] {Staff.getFullname(),Staff.getBirthday(),Staff.getCitizenId(),
        Staff.getPhonenumber(),Staff.getEmail(),Staff.getGender(),Staff.getTaiKhoan(),Staff.getWokingday()});
    }

    @Override
    public int editStaff(Staff Staff) {
        String sql = "UPDATE `vinschool`.`nhanvien` SET  `Ten` = ?, `NgaySinh` = ?, `CCCD` = ?, `Phone` = ?, `Email` = ?, `GioiTinh` = ?, `TaiKhoan` = ?, 'NgayBatDauLam' = ? WHERE `IDNV` = ?";
        return jdbctemplate.update(sql, new Object[] {Staff.getFullname(),Staff.getBirthday(),Staff.getCitizenId(),
        Staff.getPhonenumber(),Staff.getEmail(),Staff.getGender(),Staff.getTaiKhoan(),Staff.getWokingday(),Staff.getId()});
    }

    @Override
    public int removeStaff(int id) {
        String sql = "DELETE from `vinschool`.`nhanvien` WHERE IDNV = ?";
		return jdbctemplate.update(sql);
    }
}
