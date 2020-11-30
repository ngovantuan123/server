package Entity;

import javax.persistence.*;

@Entity
@Table(name = "buoi")
public class Buoi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idBuoi;
    @Column(name = "thuchanh")
    private boolean thucHanh;
    @Column(name = "thu")
    private String thu;
    @Column(name = "tietbd")
    private int tietBD;
    @Column(name = "sotiet")
    private int soTiet;
    @Column(name = "phong")
    private String phong;
    @Column(name = "giangvien")
    private String giangVien;
    @ManyToOne
    @JoinColumn(name = "idnhom")
    private Nhom nhom;

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

    public void setNhom(Nhom nhom) {
        this.nhom = nhom;
    }

    public Nhom getNhom() {
        return nhom;
    }
}
