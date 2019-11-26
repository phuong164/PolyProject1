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
import model.Menu;

/**
 *
 * @author ADMIN
 */
public class HoaDonDao {
    public void insert(Menu model) {
        String sql = "INSERT INTO MENU (maSP, tenSP, gia, hinh) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getGia(),
                model.getHinh());
    }

    public void update(Menu model) {
        String sql = "UPDATE MENU SET tenSP=?, gia=?, hinh=? WHERE maSP=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenSP(),
                model.getGia(),
                model.getHinh(),
                model.getMaSP());
    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM MENU WHERE maSP=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }

    public List<Menu> select() {
        String sql = "SELECT * FROM MENU";
        return select(sql);
    }

    public List<Menu> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM MENU WHERE tenSP LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    private List<Menu> select(String sql, Object... args) {
        List<Menu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Menu model = readFromResultSet(rs);
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

    private Menu readFromResultSet(ResultSet rs) throws SQLException {
        Menu model = new Menu();
        model.setMaSP(rs.getString("MaSP"));
        model.setTenSP(rs.getString("TenSP"));
        model.setGia(rs.getFloat("Gia"));
        model.setHinh(rs.getString("Hinh"));
        return model;
    }
}
