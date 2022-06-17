package entitys;

import javax.persistence.*;

@Entity
@Table(name = "chuyenDe")
public class ChuyenDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tenCD", length = 50)
    private String tenCD;

    @Column(name = "hocPhi")
    private Double hocPhi;

    @Column(name = "thoiLuong")
    private Integer thoiLuong;

    @Column(name = "moTa", length = 150)
    private String moTa;
    @Column(name = "status")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}