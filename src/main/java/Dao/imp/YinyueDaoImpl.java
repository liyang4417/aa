package Dao.imp;

import Dao.BaseDao;
import Dao.YinyueDao;
import entity.Yinyue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2019-02-24.
 */
public class YinyueDaoImpl extends BaseDao implements YinyueDao{
    @Override
    public List<Yinyue> selectAll() {
        List<Yinyue> list=new ArrayList<>();
        conn=connection();
        String sql="select * from yinyue";
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Yinyue yinyue=new Yinyue();
                yinyue.setId(rs.getInt("id"));
                yinyue.setName(rs.getString("name"));
                yinyue.setDizhi(rs.getString("dizhi"));
                list.add(yinyue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int add(Yinyue yinyue) {
        conn=connection();
        String sql="insert into yinyue(name,dizhi)values(?,?)";
        Object[] obj={
                yinyue.getName(),
                yinyue.getDizhi()
        };
        return exceuteUpdate(sql,obj);
    }

    @Override
    public int delete(int id) {
        String sql=" delete from yinyue where id=?";
        Object[] obj={
                id
        };
        return exceuteUpdate(sql,obj);
    }

    @Override
    public int update(Yinyue z) {
        conn=connection();
        String sql="update yinyue set name=?,dizhi=? where id=?";
        Object[] objects={
                z.getName(),
                z.getDizhi(),
                z.getId()
        };
        return exceuteUpdate(sql,objects);
    }

    @Override
    public Yinyue selectByid(Integer id) {
        Yinyue yinyue=new Yinyue();
        conn=connection();
        String sql="select id,name,dizhi from yinyue where id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while (rs.next()){
                yinyue.setId(rs.getInt("id"));
                yinyue.setName(rs.getString("name"));
                yinyue.setDizhi(rs.getString("dizhi"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return yinyue;
    }
}
