package dao;

import entitys.KhoaHoc;

import java.util.List;

public class khoaHocDao extends AbstractDao<KhoaHoc> implements DaoInterface<KhoaHoc>{
    @Override
    public KhoaHoc findById(Integer id) {
        return super.findById(KhoaHoc.class,id);
    }

    @Override
    public List<KhoaHoc> findAll() {
        return super.findAll(KhoaHoc.class,1);
    }
}
