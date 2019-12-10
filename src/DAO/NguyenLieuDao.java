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
import model.NguyenLieu;

/**
 *
 * @author OS
 */
public class NguyenLieuDao {
     public void insert(NguyenLieu model) {
        String sql = "INSERT INTO NGUYENLIEU (tenNL,soLuong,donGia,nCC) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getTenNL(),
                model.getSoLuong(),
                model.getDonGia(),
                model.getnCC());
    }

    public void update(NguyenLieu model) {
        String sql = "UPDATE NGUYENLIEU SET soLuong=?, donGia=?, nCC=?, WHERE tenNL=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenNL(),
                model.getSoLuong(),
                model.getDonGia(),
                model.getnCC());
    }

    public void delete(String tenNL) {
        String sql = "DELETE FROM NGUYENLIEU WHERE tenNL=?";
        JdbcHelper.executeUpdate(sql, tenNL);
    }

    public List<NguyenLieu> select() {
        String sql = "SELECT * FROM NGUYENLIEU";
        return (List<NguyenLieu>) select(sql);
    }

    public NguyenLieu findById(String tenNL) {
        String sql = "SELECT * FROM NGUYENLIEU WHERE tenNL=?";
        List<NguyenLieu> list = (List<NguyenLieu>) select(sql, tenNL);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<NguyenLieu> select(String sql, Object... args) {
        List<NguyenLieu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NguyenLieu model = readFromResultSet(rs);
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

    private NguyenLieu readFromResultSet(ResultSet rs) throws SQLException {
        NguyenLieu model = new NguyenLieu();
        model.setTenNL(rs.getString("tenNL"));
        model.setSoLuong(rs.getInt("soLuong"));
        model.setDonGia(rs.getFloat("donGia"));
        model.setnCC(rs.getString("nCC"));
        return model;
    }
}

