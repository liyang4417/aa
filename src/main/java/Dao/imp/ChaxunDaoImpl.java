package Dao.imp;

import Dao.BaseDao;
import Dao.ChaxunDao;
import entity.Denglu;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2019-02-22.
 */
public class ChaxunDaoImpl extends BaseDao implements ChaxunDao{
    @Override
    public List<Denglu> selectAll() {
        List<Denglu> list=new ArrayList<>();
        conn=connection();
        String sql="select * from zhuce";
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Denglu denglu1=new Denglu();
                denglu1.setId(rs.getInt("id"));
                denglu1.setUser(Integer.parseInt(rs.getString("user")));
                denglu1.setPwd(rs.getInt("pwd"));
                list.add(denglu1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(Denglu d) {
        conn=connection();
        String sql="insert into zhuce(user,pwd)values(?,?)";
        Object[] obj={
                d.getUser(),
                d.getPwd()
        };
        return exceuteUpdate(sql,obj);
    }

    @Override
    public int delete(int id) {
        String sql=" delete from zhuce where id=?";
        Object[] obj={
                id
        };
        return exceuteUpdate(sql,obj);
    }
}
