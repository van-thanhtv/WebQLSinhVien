package entitys;

import javax.persistence.*;
import java.time.LocalDate;
import java.sql.Date;

@Entity
@Table(name = "khoaHoc")
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCD")
    private ChuyenDe idCD;

    @Column(name = "hocPhi")
    private Double hocPhi;

    @Column(name = "thoiLuong")
    private Integer thoiLuong;

    @Column(name = "ngayKG")
    private Date ngayKG;

    @Column(name = "ghiChu", length = 150)
    private String ghiChu;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "status")
    private Integer status;
    @Column(name = "tenKH")
    private String tenKH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNV")
    private NhanVien idNV;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChuyenDe getIdCD() {
        return idCD;
    }

    public void setIdCD(ChuyenDe idCD) {
        this.idCD = idCD;
    }

    public Double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(Double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public Integer getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(Integer thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public Date getNgayKG() {
        return ngayKG;
    }

    public void setNgayKG(Date ngayKG) {
        this.ngayKG = ngayKG;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public NhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien idNV) {
        this.idNV = idNV;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
}