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
public class KhachHang implements Serializable{
    private String MaKH;
    private String TenKH;
    private int SoDT;
    private Date NgaySinh;
    private int Diem;

    @Override
    public String toString() {
        return this.TenKH;
        
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public int getSoDT() {
        return SoDT;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public int getDiem() {
        return Diem;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setSoDT(int SoDT) {
        this.SoDT = SoDT;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setDiem(int Diem) {
        this.Diem = Diem;
    }
    
    
}
