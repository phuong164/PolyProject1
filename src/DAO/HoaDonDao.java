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
import model.HoaDon;

/**
 *
 * @author ADMIN
 */
public class HoaDonDao {

    public void insert(HoaDon model) {
        String sql = "INSERT INTO HOADON (maHD,maNV, maKH, thanhTien, ngayXuatHD) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaHD(),
                model.getMaNV(),
                model.getMaKH(),
                model.getThanhTien(),
                model.getNgayXuatHD());
    }

    public void update(HoaDon model) {
        String sql = "UPDATE HOADON SET maNV=?, maKH=?, thanhTien=? ngayXuatHD=? WHERE maHD=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaNV(),
                model.getMaKH(),
                model.getThanhTien(),
                model.getNgayXuatHD(),
                model.getMaHD());
    }

    public void delete(String MaHD) {
        String sql = "DELETE FROM HOADON WHERE maHD=?";
        JdbcHelper.executeUpdate(sql, MaHD);
    }

     public HoaDon findById(String mahd) {
        String sql = "SELECT * FROM HOADON WHERE maHD=?";
        List<HoaDon> list = select(sql, mahd);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<HoaDon> select() {
        String sql = "SELECT * FROM HOADON";
        return select(sql);
    }

    private List<HoaDon> select(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDon model = readFromResultSet(rs);
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

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();
        model.setMaHD(rs.getString("MaHD"));
        model.setMaNV(rs.getString("MaNV"));
        model.setMaKH(rs.getInt("MaKH"));
        model.setThanhTien(rs.getFloat("ThanhTien"));
        model.setNgayXuatHD(rs.getDate("NgayXuatHD"));
        return model;
    }
}
