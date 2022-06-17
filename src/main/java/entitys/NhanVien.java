package entitys;

import javax.persistence.*;

@Entity
@Table(name = "nhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "matKhau", length = 200)
    private String matKhau;

    @Column(name = "hoTen", length = 50)
    private String hoTen;

    @Column(name = "vaiTro")
    private Integer vaiTro;

    @Column(name = "status")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Integer getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(Integer vaiTro) {
        this.vaiTro = vaiTro;
    }

}