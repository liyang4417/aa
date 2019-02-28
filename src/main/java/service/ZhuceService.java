package service;

import entity.Zhuce;

import java.util.List;

/**
 * Created by LENOVO on 2019-02-21.
 */
public interface ZhuceService {
    int add(Zhuce zhuce);
    int Update(Zhuce z);
    List<Zhuce> selectByid(Integer id);

}
