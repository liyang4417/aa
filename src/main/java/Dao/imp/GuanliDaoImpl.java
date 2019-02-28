package Dao.imp;

import Dao.BaseDao;
import Dao.GuanliDao;
import entity.guanli;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2019-02-27.
 */
public class GuanliDaoImpl extends BaseDao implements GuanliDao{

    @Override
    public List<guanli> selectAll() {
        List<guanli> list=new ArrayList<>();
        conn=connection();
        String sql="select * from guanli";
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                guanli guanli=new guanli();
                guanli.setId(rs.getInt("id"));
                guanli.setName(rs.getString("name"));
                guanli.setPwd(rs.getString("pwd"));
                list.add(guanli);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(guanli gl) {
        conn=connection();
        String sql="insert into guanli(name,pwd)values(?,?)";
        Object[] obj={
                gl.getName(),
                gl.getPwd()
        };
        return exceuteUpdate(sql,obj);
    }

    @Override
    public int delete(int id) {
        String sql=" delete from guanli where id=?";
        Object[] obj={
                id
        };
        return exceuteUpdate(sql,obj);
    }

    @Override
    public int update(guanli z) {
        conn=connection();
        String sql="update guanli set name=?,pwd=? where id=?";
        Object[] objects={
                z.getName(),
                z.getPwd(),
                z.getId()
        };
        return exceuteUpdate(sql,objects);
    }

    @Override
    public guanli selectByid(Integer id) {
        conn=connection();
        guanli guanl=new guanli();
        String sql="select id,name,pwd from guanli where id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while (rs.next()){

                guanl.setId(rs.getInt("id"));
                guanl.setName(rs.getString("name"));
                guanl.setPwd(rs.getString("pwd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guanl;
    }
}
