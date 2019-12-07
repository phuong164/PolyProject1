/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author OS
 */
public class NguyenLieu implements Serializable {
    
    private String maNL;
    private String tenNL;
    private int soLuong;
    private float donGia;
    private String nCC;

    public NguyenLieu() {
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public void setnCC(String nCC) {
        this.nCC = nCC;
    }

    public String getMaNL() {
        return maNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public String getnCC() {
        return nCC;
    }


}
