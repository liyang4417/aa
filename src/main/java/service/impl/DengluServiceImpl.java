package service.impl;

import Dao.DengluDao;
import Dao.imp.DengluDaoImp;
import entity.Denglu;
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
}
