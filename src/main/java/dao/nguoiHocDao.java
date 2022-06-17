package dao;

import entitys.NguoiHoc;
import entitys.NhanVien;

import java.util.List;

public class nguoiHocDao extends AbstractDao<NguoiHoc> implements DaoInterface<NguoiHoc>{
    @Override
    public NguoiHoc findById(Integer id) {
        return super.findById(NguoiHoc.class,id);
    }

    @Override
    public List<NguoiHoc> findAll() {
        return super.findAll(NguoiHoc.class,1);
    }

    public NguoiHoc findByEmail(String email){
        String jpql = "SELECT o FROM NguoiHoc o Where o.email =?0";
        return super.findOne(NguoiHoc.class,jpql,email);
    }
    public NguoiHoc findByPhone(String phone){
        String jpql = "SELECT o FROM NguoiHoc o Where o.sdt =?0";
        return super.findOne(NguoiHoc.class,jpql,phone);
    }
}
