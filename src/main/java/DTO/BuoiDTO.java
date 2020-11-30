package DTO;



public class BuoiDTO {
    private int idBuoi;
    private boolean thucHanh;
    private String thu;
    private int tietBD;
    private int soTiet;
    private String phong;
    private String giangVien;
    private NhomDTO nhom;

    public int getIdBuoi() {
        return idBuoi;
    }

    public void setIdBuoi(int idBuoi) {
        this.idBuoi = idBuoi;
    }
    public boolean isThucHanh() {
        return thucHanh;
    }

    public void setThucHanh(boolean thucHanh) {
        this.thucHanh = thucHanh;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public int getTietBD() {
        return tietBD;
    }

    public void setTietBD(int tietBD) {
        this.tietBD = tietBD;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }

    public void setNhom(NhomDTO nhom) {
        this.nhom = nhom;
    }

    public NhomDTO getNhom() {
        return nhom;
    }
}
