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

/**
 *
 * @author OS
 */
public class KhachHangDao {


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
        String sql = "UPDATE KHACHHANG SET tenKH=?,soDT=?,ngaySinh=?,count( hd.maKH) as diemTL\n" +
" from KHACHHANG kh join HOADON hd on  kh.maKH =  hd.maKH where  kh.maKH = ?" +
" group by kh.maKH, kh.tenKH, kh.soDT, kh.ngaySinh";
        JdbcHelper.executeUpdate(sql,
                model.getTenKH(),
                model.getSoDT(),
                model.getNgaySinh(),
                model.getDiem(),
                model.getMaKH()
        );
    }

    public void delete(int MaKH) {
        String sql = "DELETE FROM KHACHHANG WHERE maKH=?";
        JdbcHelper.executeUpdate(sql, MaKH);
    }

    public List<KhachHang> select() {
        String sql = "select kh.maKH, tenKH, soDT, ngaySinh,count( hd.maKH) as diemTL\n"
                + " from KHACHHANG kh join HOADON hd on  kh.maKH =  hd.maKH where  kh.maKH = hd.maKH\n"
                + " group by kh.maKH, kh.tenKH, kh.soDT, kh.ngaySinh";
        return select(sql);
    }
     public List<KhachHang> select1() {
         String sql = "select * from KHACHHANG";
       return select(sql);
     }

    public KhachHang findById(int maKH) {
        String sql = "SELECT * FROM KHACHHANG WHERE maKH=?";
        List<KhachHang> list = select(sql, maKH);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<KhachHang> select(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang model = new KhachHang();
        model.setMaKH(rs.getInt("MaKH"));
        model.setTenKH(rs.getString("TenKH"));
        model.setSoDT(rs.getString("SoDT"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setDiem(rs.getInt("DiemTL"));
        return model;
    }
}
