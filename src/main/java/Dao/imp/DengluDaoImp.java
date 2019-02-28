package Dao.imp;

import Dao.BaseDao;
import Dao.DengluDao;
import entity.Denglu;
import entity.guanli;

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

    @Override
    public int tt(guanli guanl) {
        int t=0;
        conn=connection();
        String sql="select count(0) as r from guanli where name=? and pwd=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,guanl.getName());
            pstmt.setString(2,guanl.getPwd());
            rs=pstmt.executeQuery();
            while (rs.next()){
                t=rs.getInt("r");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public int add(guanli guanl) {
        conn=connection();
        String sql="insert into guanli(name,pwd)values(?,?)";
        Object[] obj={
                guanl.getName(),
                guanl.getPwd()
        };
        return exceuteUpdate(sql,obj);
    }
}
