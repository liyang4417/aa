package service.impl;

import Dao.DengluDao;
import Dao.imp.DengluDaoImp;
import entity.*;
import entity.guanli;
import service.DengluService;

/**
 * Created by LENOVO on 2019-01-04.
 */
public class DengluServiceImpl implements DengluService {
    DengluDao dengluDao=new DengluDaoImp();
    @Override
    public boolean login(Denglu denglu) {
        if (dengluDao.login(denglu)==0) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean tt(guanli guanl) {
        if (dengluDao.tt(guanl)==0) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public int add(guanli guanl) {
        return dengluDao.add(guanl);
    }
}
