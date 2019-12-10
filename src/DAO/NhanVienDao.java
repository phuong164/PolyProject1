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
import model.Doipass;
import model.NhanVien;

/**
 *
 * @author Admin
 */
public class NhanVienDao {

    public void insert(NhanVien model) {
        String sql = "INSERT INTO NHANVIEN (maNV, matKhau, hoTen, vaiTro) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaNV(),
                model.getMatKhau(),
                model.getHoTen(),
                model.isVaiTro());
    }

    public void update(NhanVien model) {
        String sql = "UPDATE NHANVIEN SET matKhau=?, hoTen=?, vaiTro=? WHERE maNV=?";
        JdbcHelper.executeUpdate(sql,
                model.getMatKhau(),
                model.getHoTen(),
                model.isVaiTro(),
                model.getMaNV());
    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM NHANVIEN WHERE maNV=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }

    public List<NhanVien> select() {
        String sql = "SELECT * FROM NHANVIEN";
        return select(sql);
    }

    public List<NhanVien> selectByName() {
        String sql = "SELECT hoTen FROM NHANVIEN";
        return select(sql);
    }

    public NhanVien findById(String manv) {
        String sql = "SELECT * FROM NHANVIEN WHERE maNV=?";
        List<NhanVien> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
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

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("maNV"));
        model.setMatKhau(rs.getString("matKhau"));
        model.setHoTen(rs.getString("hoTen"));
        model.setVaiTro(rs.getBoolean("vaiTro"));
        return model;
    }
    public void update1(Doipass model) {
        String sql = "UPDATE NHANVIEN SET matKhau=? WHERE maNV=?";
        JdbcHelper.executeUpdate(sql,
                model.getMatkhau(),
                model.getMaNV());

    }
}
