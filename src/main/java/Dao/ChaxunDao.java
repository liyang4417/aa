package Dao;

import entity.Denglu;
import entity.Zhuce;

import java.util.List;

/**
 * Created by LENOVO on 2019-02-22.
 */
public interface ChaxunDao {
    List<Denglu> selectAll();
    int add(Denglu d);
    int delete(int id);
}
