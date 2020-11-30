package DTO;

import java.util.ArrayList;
import java.util.List;


public class MonHocDTO {
    
    private int id;
    private String maMH;
    private String tenMonHoc;
    private String soTinChi;
    private List<NhomDTO> nhoms = new ArrayList();


    public List<NhomDTO> getNhom() {
        return nhoms;
    }

    public void setNhom(List<NhomDTO> nhom) {
        this.nhoms = nhom;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(String soTinChi) {
        this.soTinChi = soTinChi;
    }
}
