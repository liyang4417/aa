package Dao;
import entity.Yinyue;

import java.util.List;

/**
 * Created by LENOVO on 2019-02-24.
 */
public interface YinyueDao {
    List<Yinyue> selectAll();
    int add(Yinyue yinyue);
    int delete(int id);
    int update(Yinyue z);
    Yinyue selectByid(Integer id);

}
