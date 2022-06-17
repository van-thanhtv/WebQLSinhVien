package dao;

import entitys.ChuyenDe;

import java.util.List;

public class chuyenDeDao extends AbstractDao<ChuyenDe> implements DaoInterface<ChuyenDe>{
    @Override
    public ChuyenDe findById(Integer id) {
        return super.findById(ChuyenDe.class,id);
    }

    @Override
    public List<ChuyenDe> findAll() {
        return super.findAll(ChuyenDe.class,1);
    }
}
