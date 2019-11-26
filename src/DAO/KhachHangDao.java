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
import model.KhachHang;
import model.Menu;

/**
 *
 * @author OS
 */
public class KhachHangDao {

    private String maKH;

    public void insert(KhachHang model) {
        String sql = "INSERT INTO KHACHHANG (maKH,tenKH,soDT,ngaySinh,diemTL) VALUES (?, ?, ?, ?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaKH(),
                model.getTenKH(),
                model.getSoDT(),
                model.getNgaySinh(),
                model.getDiem());
    }

    public void update(KhachHang model) {
        String sql = "INSERT INTO KHACHHANG (maKH,tenKH,soDT,ngaySinh,diemTL) VALUES (?, ?, ?, ?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaKH(),
                model.getTenKH(),
                model.getSoDT(),
                model.getNgaySinh(),
                model.getDiem());
    }

    public void delete(String MaKH) {
        String sql = "DELETE FROM KHACHHANG WHERE MaKH=?";
        JdbcHelper.executeUpdate(sql, MaKH);
    }

    public List<KhachHang> select() {
        String sql = "SELECT * FROM KHACHHANG";
        return select(sql, maKH);
    }



    public KhachHang findById(String maKH) {
        String sql = "SELECT * FROM KHACHHANG WHERE MaKH=?";
        List<KhachHang> list = select(sql, maKH);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<KhachHang> select(String sql, String maKH) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
//        private List<KhachHang> select(String sql, Object... args) {
//        List<Menu> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                rs = JdbcHelper.executeQuery(sql, args);
//                while (rs.next()) {
//                    Menu model = readFromResultSet(rs);
//                    list.add(model);
//                }
//            } finally {
//                rs.getStatement().getConnection().close();
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//        return list;
//    }
//private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
//        KhachHang model = new KhachHang();
//        model.setMaKH(rs.getString("MaKH"));
//        model.setTenKH(rs.getString("TenSP"));
//        model.setSoDT(rs.getInt("Gia"));
//        model.setNgaySinh(rs.getString("Hinh"));
//        return model;
//    }
}
