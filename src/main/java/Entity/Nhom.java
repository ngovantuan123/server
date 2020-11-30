package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nhom")
public class Nhom {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private int id;
    @Column(name = "idnhom")
    private int idNhom;
    @Column(name = "malop")
    private String maLop;
    @Column(name = "siso")
    private int siSo;
    @OneToMany(mappedBy = "nhom",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    //@JoinColumn(name = "idnhom",referencedColumnName = "id")
    private List<Buoi> buois = new ArrayList();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idmonhoc")
    private MonHoc monHoc;

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

    public List<Buoi> getBuois() {
        return buois;
    }

    public void setBuois(List<Buoi> buois) {
        this.buois = buois;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
