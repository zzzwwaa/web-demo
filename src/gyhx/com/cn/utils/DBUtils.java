package gyhx.com.cn.utils;


import java.sql.*;

public class DBUtils {
    public static String driverurl="com.mysql.jdbc.Driver";
    public static String mysql_url="jdbc:mysql://localhost:3306/vma?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
    public static String username="root";
    public static String password="1234";
    /**
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/要连接的数据库库名?serverTimezone=GMT%2B8
    spring.datasource.username=root
    spring.datasource.password=1234


     * 获取连接对象
     * @return
     */
    public static Connection getConnection()  {
        Connection con=null;
        try {
            Class.forName(driverurl);
            con = DriverManager.getConnection(mysql_url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     *
     * @param rs 结果集关闭
     * @param ps 数据库对象关闭
     * @param con 连接对象关闭
     */
    public static void release(ResultSet rs,PreparedStatement ps,Connection con){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
