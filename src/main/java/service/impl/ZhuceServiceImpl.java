package service.impl;

import Dao.ZhuceDao;
import Dao.imp.ZhuceDaoImpl;
import entity.Zhuce;
import service.ZhuceService;

import java.util.List;

/**
 * Created by LENOVO on 2019-02-21.
 */
public class ZhuceServiceImpl implements ZhuceService{
    ZhuceDao zhuceDao=new ZhuceDaoImpl();
    @Override
    public int add(Zhuce zhuce) {
        return zhuceDao.add(zhuce);
    }

    @Override
    public int Update(Zhuce z) {
        return zhuceDao.Update(z);
    }

    @Override
    public List<Zhuce> selectByid(Integer id) {
        return zhuceDao.selectByid(id);
    }
}
