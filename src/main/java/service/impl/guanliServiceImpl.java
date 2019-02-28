package service.impl;

import Dao.GuanliDao;
import Dao.imp.GuanliDaoImpl;
import entity.guanli;
import service.guanliService;

import java.util.List;

/**
 * Created by LENOVO on 2019-02-27.
 */
public class guanliServiceImpl implements guanliService {
    GuanliDao guanliDao=new GuanliDaoImpl();
    @Override
    public List<guanli> selectAll() {
        return guanliDao.selectAll();
    }

    @Override
    public int add(guanli gl) {
        return guanliDao.add(gl);
    }

    @Override
    public int delete(int id) {
        return guanliDao.delete(id);
    }

    @Override
    public int update(guanli z) {
        return guanliDao.update(z);
    }

    @Override
    public guanli selectByid(Integer id) {
        return guanliDao.selectByid(id);
    }
}
