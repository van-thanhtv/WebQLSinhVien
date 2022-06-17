package dao;

import entitys.HocVien;

import java.util.List;

public class hocVienDao extends AbstractDao<HocVien> implements DaoInterface<HocVien>{
    @Override
    public HocVien findById(Integer id) {
        return super.findById(HocVien.class,id);
    }

    @Override
    public List<HocVien> findAll() {
        return super.finAll(HocVien.class);
    }
    public List<HocVien> findByKH(Integer id) {
        return super.findMany(HocVien.class, "SELECT obj from HocVien obj where obj.idKH.id= ?0", id);
    }
}
