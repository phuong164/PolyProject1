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
import model.HoaDonCT;

/**
 *
 * @author ADMIN
 */
public class HDCTDao {

    public void insert(HoaDonCT model) {
        String sql = "INSERT INTO HDCT (maSP, tenSP,soLuong, gia) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getSoLuong(),
                model.getGia()
        );
    }

    public void update(HoaDonCT model) {
        String sql = "UPDATE HDCT SET tenSP=?, soLuong=?, gia=? WHERE maSP=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenSP(),
                model.getSoLuong(),
                model.getGia(),
                model.getMaSP());
    }

    public List<HoaDonCT> select() {
        String sql = "SELECT * FROM HDCT";
        return select(sql);
    }

    private List<HoaDonCT> select(String sql, Object... args) {
        List<HoaDonCT> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonCT model = readFromResultSet(rs);
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

    private HoaDonCT readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonCT model = new HoaDonCT();
        model.setMaSP(rs.getString("MaSP"));
        model.setTenSP(rs.getString("TenSP"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGia(rs.getFloat("Gia"));
        return model;
    }

    public void delete(String masp) {
        String sql = "DELETE FROM HDCT WHERE maSP=?";
        JdbcHelper.executeUpdate(sql, masp);
    }
}
