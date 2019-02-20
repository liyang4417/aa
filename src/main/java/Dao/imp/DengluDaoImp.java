package Dao.imp;

import Dao.BaseDao;
import Dao.DengluDao;
import entity.Denglu;

import java.sql.SQLException;

/**
 * Created by LENOVO on 2019-01-04.
 */
public class DengluDaoImp extends BaseDao implements DengluDao{
    @Override
    public int login(Denglu denglu) {
        int num=0;
        conn=connection();
        String sql="select count(0) as r from zhuce where user=? and pwd=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,denglu.getUser());
            pstmt.setInt(2,denglu.getPwd());
            rs=pstmt.executeQuery();
            while (rs.next()){
                  num=rs.getInt("r");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
