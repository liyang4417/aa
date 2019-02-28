package Dao;
import entity.guanli;
import java.util.List;

/**
 * Created by LENOVO on 2019-02-27.
 */
public interface GuanliDao {
   List<guanli> selectAll();
    int add(guanli gl);
    int delete(int id);
    int update(guanli z);
    guanli selectByid(Integer id);
}
