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
import model.HDCT;

/**
 *
 * @author ADMIN
 */
public class HDCTDao {

    public void insert(HDCT model) {
        String sql = "INSERT INTO HDCT (maHD, maSP,tenSP, soLuong,gia, thanhTien) VALUES(?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMahd(),
                model.getMasp(),
                model.getTensp(),
                model.getSoluong(),
                model.getGia(),
                model.getThanhtien()
        );
        System.out.println(sql);
    }

    public void delete(String mahd) {
        String sql = "DELETE FROM HDCT WHERE maHD=?";
        JdbcHelper.executeUpdate(sql, mahd);
    }

    public HDCT findById(String mahd) {
        String sql = "SELECT * FROM HDCT WHERE maHD=?";
        List<HDCT> list = select(sql, mahd);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<HDCT> select() {
        String sql = "SELECT * FROM HDCT";
        return select(sql);
    }

    public List<HDCT> selectByMaHD(String maHD) {
        String sql = "SELECT * FROM HDCT where maHD like ? ";
        return select(sql, "%" + maHD + "%");
    }

    private List<HDCT> select(String sql, Object... args) {
        List<HDCT> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HDCT model = readFromResultSet(rs);
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

    private HDCT readFromResultSet(ResultSet rs) throws SQLException {
        HDCT model = new HDCT();
        model.setMahd(rs.getString("MaHD"));
        model.setMasp(rs.getString("MaSP"));
        model.setTensp(rs.getString("TenSP"));
        model.setSoluong(rs.getInt("SoLuong"));
        model.setGia(rs.getFloat("Gia"));
        model.setThanhtien(rs.getFloat("ThanhTien"));
        return model;
    }

}
