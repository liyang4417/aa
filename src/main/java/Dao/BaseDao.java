package Dao;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by LENOVO on 2018-12-06.
 */
public class BaseDao {
    private static String driver="";
    private static String url="";
    private static String user="";
    private static String pwd="";

    public Connection conn=null;
    public PreparedStatement pstmt=null;
    public ResultSet rs=null;

    static {
        try {
            Properties properties=new Properties();
            InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("BaseDao.properties");
            properties.load(is);
            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            pwd=properties.getProperty("password");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection connection(){
            try {
                conn = DriverManager.getConnection(url, user, pwd);
            } catch (SQLException e) {
                e.printStackTrace();
        }
        return  conn;
    }
    public void closeAll(){
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt!=null){
                pstmt.close();
            }
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int exceuteUpdate(String sql,Object[] param){
        conn=connection();
        int num=0;
        try {
            pstmt=conn.prepareStatement(sql);
            if (param!=null){
                for (int i=0;i<param.length;i++){
                    pstmt.setObject(i+1,param[i]);
                }
            }
            num=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return num;
    }
}


