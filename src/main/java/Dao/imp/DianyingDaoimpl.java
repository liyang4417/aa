package Dao.imp;

import Dao.BaseDao;
import Dao.DianyingDao;
import entity.Dianying;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2019-02-27.
 */
public class DianyingDaoimpl extends BaseDao implements DianyingDao{
    @Override
    public List<Dianying> selectAll() {
        List<Dianying> list=new ArrayList<>();
        conn=connection();
        String sql="select * from dianying";
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Dianying dianying=new Dianying();
                dianying.setId(rs.getInt("id"));
                dianying.setName(rs.getString("name"));
                dianying.setDdizhi(rs.getString("dizhi"));
                list.add(dianying);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
