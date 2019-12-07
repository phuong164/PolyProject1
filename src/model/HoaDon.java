/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class HoaDon {
    private String maHD;
    private String maNV;
    private int maKH;
    private Float thanhTien;
    private Date ngayXuatHD;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maNV, int maKH, Float thanhTien, Date ngayXuatHD) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.thanhTien = thanhTien;
        this.ngayXuatHD = ngayXuatHD;
    }


    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public Float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Date getNgayXuatHD() {
        return ngayXuatHD;
    }

    public void setNgayXuatHD(Date ngayXuatHD) {
        this.ngayXuatHD = ngayXuatHD;
    }
    
}
