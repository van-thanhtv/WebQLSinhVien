package entitys;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "nguoiHoc")
public class NguoiHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "hoTen", length = 50)
    private String hoTen;

    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @Column(name = "sdt", length = 15)
    private String sdt;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "ghiChu", length = 150)
    private String ghiChu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNV")
    private NhanVien idNV;

    @Column(name = "ngayDK")
    private Date ngayDK;

    @Column(name = "status")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public NhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien idNV) {
        this.idNV = idNV;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}