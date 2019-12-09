/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author OS
 */
public class KhachHang implements Serializable {

    private int maKH;
    private String tenKH;
    private int soDT;
    private Date ngaySinh;
    private int diem;

    public KhachHang() {
    }

    public KhachHang(int maKH, String tenKH, int soDT, Date ngaySinh, int diem) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.soDT = soDT;
        this.ngaySinh = ngaySinh;
        this.diem = diem;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getSoDT() {
        return soDT;
    }

    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

   
    
    
}
