package Dao.imp;
import entity.Zhuce;
import Dao.BaseDao;
import Dao.ZhuceDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2019-02-21.
 */
public class ZhuceDaoImpl extends BaseDao implements ZhuceDao {
    @Override
    public int add(Zhuce zhuce) {
        String sql="insert into zhuce values(null,?,?)";
        Object[] objs={zhuce.getUser(),zhuce.getPwd()};
        return exceuteUpdate(sql,objs);
    }

    @Override
    public int Update(Zhuce z) {
        conn=connection();
        String sql="update zhuce set pwd=?,user=? where id=?";
        Object[] objects={
                z.getPwd(),
                z.getUser(),
                z.getId()
        };
        return exceuteUpdate(sql,objects);
    }

    @Override
    public List<Zhuce> selectByid(Integer id) {
        Zhuce zhuce=new Zhuce();
        conn=connection();
        List<Zhuce>list=new ArrayList<>();
        String sql="select id,user,pwd from zhuce where id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while (rs.next()){
                zhuce.setId(rs.getInt("id"));
                zhuce.setUser(Integer.parseInt(rs.getString("user")));
                zhuce.setPwd(rs.getInt("pwd"));
                list.add(zhuce);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
