package com.example.vinschool.DAO.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.vinschool.DAO.InforCheckOutDAO;
import com.example.vinschool.Model.InforCheckOut;
import com.example.vinschool.Model.Mapper.InforCheckOutMapper;

@Repository
public class InforCheckOutDAOImp implements InforCheckOutDAO{
    
    @Autowired
    JdbcTemplate jdbctemplate;

    @Override
    public int addThongtinthanhtoan(InforCheckOut inforCheckOut){
        String sql = "INSERT INTO `vinschool`.`thongtinthanhtoan` (`idTT`, `idPhieu`, `idHP`, `thue`, `tenchuthe`, `sotaikhoan`, `ngayhethan`, `ngaythanhtoan`, `tongtien`) VALUES (?, ?, ?, ?, ?, ?, STR_TO_DATE(?, '%Y-%m'), CURDATE(), ?);";
        return jdbctemplate.update(sql, new Object[]{inforCheckOut.getIdTT(),inforCheckOut.getIdTicket(),inforCheckOut.getIdHP(),
        inforCheckOut.getThue(),inforCheckOut.getTenchuthe(),inforCheckOut.getSotaikhoan(),inforCheckOut.getNgayhethan(),inforCheckOut.getTongtien()});
    }

    @Override
    public List<InforCheckOut> findThongTinThanhToanByIdCus(int idCustomer){
        String sql = "SELECT idTT,dk.idPhieu,idHP,thue,tenchuthe,sotaikhoan, ngayhethan,ngaythanhtoan,tongtien,dk.tenHocSinh,dk.ngaySinhHocSinh,dk.lophoc FROM thongtinthanhtoan tt join phieudangky dk on tt.idPhieu = dk.idPhieu where dk.idkh = "+idCustomer+"";
        List<InforCheckOut> list = jdbctemplate.query(sql, new InforCheckOutMapper());
        return list;
    }

    @Override
    public Boolean CheckThongTinThanhToanByIdCus(int idCustomer){
        String sql = "SELECT idTT,dk.idPhieu,idHP,thue,tenchuthe,sotaikhoan, ngayhethan,ngaythanhtoan,tongtien,dk.tenHocSinh,dk.ngaySinhHocSinh,dk.lophoc FROM thongtinthanhtoan tt join phieudangky dk on tt.idPhieu = dk.idPhieu where dk.idkh = "+idCustomer+"";
        List<InforCheckOut> list = jdbctemplate.query(sql, new InforCheckOutMapper());
        if(list.size()>0){
            return true;
        }else{
            return false;
        }
        
    }

    @Override
    public List<InforCheckOut> showList(){
        String sql = "SELECT idTT,dk.idPhieu,idHP,thue,tenchuthe,sotaikhoan, ngayhethan,ngaythanhtoan,tongtien,dk.tenHocSinh,dk.ngaySinhHocSinh,dk.lophoc FROM thongtinthanhtoan tt join phieudangky dk on tt.idPhieu = dk.idPhieu";
        List<InforCheckOut> list = jdbctemplate.query(sql, new InforCheckOutMapper());
        if(list.size()>0){
            return list;
        }else{
            return null;
        }
    }
    
}
