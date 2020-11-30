package data;

import java.util.List;

public class tbl_Monhoc {
    private String ma;
    private String ten;

    public List<String> getThuchanh() {
        return thuchanh;
    }

    public void setThuchanh(List<String> thuchanh) {
        this.thuchanh = thuchanh;
    }

    private String nhom;
    private String stc;
    private String maLop;
    private String siSo;
    private  List<String> thuchanh;
    private List<String> thu;
    private List<String> tietBD;
    private List<String> soTiet;
    private List<String> phong;
    private List<String> giangVien;

    public tbl_Monhoc(String ma, String ten, String nhom, String stc, String maLop, String siSo, List<String> thu, List<String> tietBD, List<String> soTiet, List<String> phong, List<String> giangVien) {
        this.ma = ma;
        this.ten = ten;
        this.nhom = nhom;
        this.stc = stc;
        this.maLop = maLop;
        this.siSo = siSo;
        this.thu = thu;
        this.tietBD = tietBD;
        this.soTiet = soTiet;
        this.phong = phong;
        this.giangVien = giangVien;
    }

    public tbl_Monhoc() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    public String getStc() {
        return stc;
    }

    public void setStc(String stc) {
        this.stc = stc;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getSiSo() {
        return siSo;
    }

    public void setSiSo(String siSo) {
        this.siSo = siSo;
    }

    public List<String> getThu() {
        return thu;
    }

    public void setThu(List<String> thu) {
        this.thu = thu;
    }

    public List<String> getTietBD() {
        return tietBD;
    }

    public void setTietBD(List<String> tietBD) {
        this.tietBD = tietBD;
    }

    public List<String> getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(List<String> soTiet) {
        this.soTiet = soTiet;
    }

    public List<String> getPhong() {
        return phong;
    }

    public void setPhong(List<String> phong) {
        this.phong = phong;
    }

    public List<String> getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(List<String> giangVien) {
        this.giangVien = giangVien;
    }


}
