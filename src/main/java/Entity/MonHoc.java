package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "monhoc")
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "mamh",nullable = false)
    private String maMH;
    @Column(name = "tenmonhoc")
    private String tenMonHoc;
    @Column(name = "sotinchi")
    private String soTinChi;
    @OneToMany(mappedBy = "monHoc",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    //@JoinColumn(name = "idmonhoc",referencedColumnName = "id")
    private List<Nhom> nhoms = new ArrayList();


    public List<Nhom> getNhom() {
        return nhoms;
    }

    public void setNhom(List<Nhom> nhom) {
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
