package dao;

import entitys.NhanVien;

import java.util.List;

public class nhanVienDao extends AbstractDao<NhanVien> implements DaoInterface<NhanVien>{
    @Override
    public NhanVien findById(Integer id) {
        return super.findById(NhanVien.class,id);
    }

    @Override
    public List<NhanVien> findAll() {
        return super.findAll(NhanVien.class,1);
    }
    public NhanVien findByEmail(String email){
        String jpql = "SELECT o FROM NhanVien o Where o.email =?0";
        return super.findOne(NhanVien.class,jpql,email);
    }
}
