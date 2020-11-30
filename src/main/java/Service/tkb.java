package Service;

import java.util.List;
import java.util.Map;

public class tkb {
    public String thu;
    public String maMH;
    public String tenMH;
    public String maNhom;
    public int sotiet ;
    public int tietBD ;
    public int tietKT = tietBD + sotiet ;
    public boolean thuchanh;
    public String phonghoc;
    public String giangvien;

    public String thuAndTietBD ;

    public String getThuAndTietBD() {
        return tenMH+thu+tietBD;
    }

    public void setThuAndTietBD(String thuAndTietBD) {
        this.thuAndTietBD = thuAndTietBD;
    }

    public tkb() {
    }

    public tkb( String maNhom,String tenMH) {
        this.tenMH = tenMH;
        this.maNhom = maNhom;
    }

    public tkb(String thu, String maMH, String tenMH, String maNhom, int sotiet, int tietBD, int tietKT, boolean thuchanh, String phonghoc, String giangvien) {
        this.thu = thu;
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.maNhom = maNhom;
        this.sotiet = sotiet;
        this.tietBD = tietBD;
        this.tietKT = tietKT;
        this.thuchanh = thuchanh;
        this.phonghoc = phonghoc;
        this.giangvien = giangvien;
    }

    @Override
    public String toString() {
        return "tkb{" +
                "thu='" + thu + '\'' +
                ", maMH='" + maMH + '\'' +
                ", tenMH='" + tenMH + '\'' +
                ", maNhom='" + maNhom + '\'' +
                ", sotiet=" + sotiet +
                ", tietBD=" + tietBD +
                ", tietKT=" + tietKT +
                ", thuchanh=" + thuchanh +
                ", phonghoc='" + phonghoc + '\'' +
                ", giangvien='" + giangvien + '\'' +
                '}';
    }

    public boolean isThuchanh() {
        return thuchanh;
    }

    public void setThuchanh(boolean thuchanh) {
        this.thuchanh = thuchanh;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public int getSotiet() {
        return sotiet;
    }

    public void setSotiet(int sotiet) {
        this.sotiet = sotiet;
    }

    public int getTietBD() {
        return tietBD;
    }

    public void setTietBD(int tietBD) {
        this.tietBD = tietBD;
    }

    public int getTietKT() {
        return tietKT;
    }

    public void setTietKT(int tietKT) {
        this.tietKT = tietKT;
    }

    public String getPhonghoc() {
        return phonghoc;
    }

    public void setPhonghoc(String phonghoc) {
        this.phonghoc = phonghoc;
    }

    public String getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(String giangvien) {
        this.giangvien = giangvien;
    }
}
