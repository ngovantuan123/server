package DTO;


import java.util.ArrayList;
import java.util.List;


public class NhomDTO {
    
    private int id;
    private int idNhom;
    private String maLop;
    private int siSo;
    private List<BuoiDTO> buois = new ArrayList();
    private MonHocDTO monHoc;

    public int getIdNhom() {
        return idNhom;
    }

    public void setIdNhom(int idNhom) {
        this.idNhom = idNhom;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public List<BuoiDTO> getBuois() {
        return buois;
    }

    public void setBuois(List<BuoiDTO> buois) {
        this.buois = buois;
    }

    public MonHocDTO getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHocDTO monHoc) {
        this.monHoc = monHoc;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
