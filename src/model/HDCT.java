/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class HDCT {
    private int ID;
    private String mahd;
    private String masp;
    private int soluong;
    private float thanhtien;

    public HDCT() {
    }

    public HDCT(int ID, String mahd, String masp, int soluong, float thanhtien) {
        this.ID = ID;
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }
    
}
