package entitys;

import javax.persistence.*;

@Entity
@Table(name = "hocVien")
public class HocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idKH")
    private KhoaHoc idKH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNH")
    private NguoiHoc idNH;

    @Column(name = "diem")
    private Integer diem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public KhoaHoc getIdKH() {
        return idKH;
    }

    public void setIdKH(KhoaHoc idKH) {
        this.idKH = idKH;
    }

    public NguoiHoc getIdNH() {
        return idNH;
    }

    public void setIdNH(NguoiHoc idNH) {
        this.idNH = idNH;
    }

    public Integer getDiem() {
        return diem;
    }

    public void setDiem(Integer diem) {
        this.diem = diem;
    }

}