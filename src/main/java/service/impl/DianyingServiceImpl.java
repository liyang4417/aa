package service.impl;

import Dao.DianyingDao;
import Dao.imp.DianyingDaoimpl;
import entity.Dianying;
import service.DianyingService;

import java.util.List;

/**
 * Created by LENOVO on 2019-02-27.
 */
public class DianyingServiceImpl implements DianyingService {
    DianyingDao dianyingDao=new DianyingDaoimpl();
    @Override
    public List<Dianying> selectAll() {
        return dianyingDao.selectAll();
    }
}
