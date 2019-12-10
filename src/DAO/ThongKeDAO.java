/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class ThongKeDAO {
     public List<Object[]> getDoanhThu() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec sp_ThongKeDoanhThuNam";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("Nam"),
                        rs.getInt("SoLuong"),
                        rs.getFloat("TongTien"),
                    };
                    list.add(model);
                }
            } finally {
                if(rs != null && rs.getStatement() != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

   
     public List<Object[]> getDoanhThuThang() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec sp_ThongKeDoanhThuThang";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("Thang"),
                        rs.getInt("SoLuong"),
                        rs.getFloat("TongTien"),
                    };
                    list.add(model);
                }
            } finally {
                if(rs != null && rs.getStatement() != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
     
     public List<Object[]> getDoanhThuNgay() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "exec sp_ThongKeDoanhThuNgay";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("Ngay"),
                        rs.getInt("SoLuong"),
                        rs.getFloat("TongTien"),
                    };
                    list.add(model);
                }
            } finally {
                if(rs != null && rs.getStatement() != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
