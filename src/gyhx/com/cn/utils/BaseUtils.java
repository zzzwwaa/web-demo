package gyhx.com.cn.utils;


import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseUtils {



    /**
     * 添加或者删除的通用写法
     * @param sql
     * @param args
     */
    public static void insertOrDelete(String sql,Object ... args)  {
        Connection con = null;
        PreparedStatement ps=null;
        try {
             con = DBUtils.getConnection();
             ps = con.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=1;i<=args.length;i++){
                    ps.setObject(i,args[i-1]);
                }
            }
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.release(null,ps,con);
        }
    }

    /**
     * 通用查询实现
     * @return
     * @throws SQLException
     */
    public static <T> List<T> queryListByParam(String sql,Class<T> c,Object...args){

        List<T> bList=new ArrayList<T>();

        Connection con = null;

        PreparedStatement ps=null;

        ResultSet rs=null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=1;i<=args.length;i++){
                    ps.setObject(i,args[i-1]);
                }
            }
            rs = ps.executeQuery();
            //获取此 ResultSet 对象的列的编号、类型和列名。
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next()){
                T obj=c.newInstance();
            /*
                int  getColumnCount()
                        返回此 ResultSet 对象中的列数。
                String getColumnName(int column)
                                获取指定列的名称。
             */
                for(int i=1;i<=metaData.getColumnCount();i++) {
                    //获取列名
                    String columnName = metaData.getColumnName(i);//publishTime
                    //获取列的对象
                    Field field = c.getDeclaredField(columnName);//publishTime
                    //获取列的值
                    Object value = rs.getObject(columnName);//少了列名
                    //打开访问权限
                    field.setAccessible(true);
                    if(value==null){
                        //获取数据类型
                        Type genericType = field.getGenericType();
                        String typeName = genericType.getTypeName();
                        if(typeName=="int"||typeName=="double"||typeName=="float"||typeName=="short"){
                            field.set(obj, 0);
                        }
                    }else{
                        field.set(obj, value);
                    }
                    //关闭访问权限
                    field.setAccessible(false);
                }
                bList.add(obj);
            }
        } catch (SQLException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }finally {
            DBUtils.release(rs,ps,con);
        }
        return bList;
    }

    /**
     * 通用单个对象实现
     * @return
     * @throws SQLException
     */

    public static <T> T queryObj(String sql,Class<T> c,Object ... args){

        T obj=null;

        Connection con = null;

        PreparedStatement ps=null;

        ResultSet rs=null;
        try {
            con = DBUtils.getConnection();
           ps = con.prepareStatement(sql);

            if(args!=null&&args.length>0){
                for(int i=1;i<=args.length;i++){
                    ps.setObject(i,args[i-1]);
                }
            }
            obj=c.newInstance();

            rs = ps.executeQuery();
            //获取此 ResultSet 对象的列的编号、类型和列名。
            ResultSetMetaData metaData = rs.getMetaData();
            if(rs.next()){
            /*
                int  getColumnCount()
                        返回此 ResultSet 对象中的列数。
                String getColumnName(int column)
                                获取指定列的名称。
             */
                for(int i=1;i<=metaData.getColumnCount();i++) {
                    //获取列名
                    String columnName = metaData.getColumnName(i);//publishTime
                    //获取列的对象
                    Field field = c.getDeclaredField(columnName);//publishTime
                    //获取列的值
                    Object value = rs.getObject(columnName);//少了列名
                    //打开访问权限
                    field.setAccessible(true);
                    if(value==null){
                        //获取数据类型
                        Type genericType = field.getGenericType();
                        String typeName = genericType.getTypeName();
                        if(typeName=="int"||typeName=="double"||typeName=="float"||typeName=="short"){
                            field.set(obj, 0);
                        }
                    }else{
                        field.set(obj, value);
                    }
                    //关闭访问权限
                    field.setAccessible(false);
                }
            }
        } catch (SQLException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }finally {
            DBUtils.release(rs,ps,con);
        }
        return obj;
    }

    /**
     *  修改方法
     * @param sql 传递的SQL语句
     * @param args 传递的参数
     * @return
     */
    public static boolean update(String sql,Object ... args)  {
        Connection con = null;
        PreparedStatement ps=null;
        boolean flag=false;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=1;i<=args.length;i++){
                    ps.setObject(i,args[i-1]);
                }
            }
            return ps.executeUpdate()>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.release(null,ps,con);
        }
        return flag;
    }

    /**
     * 统计总条数 只适用于count(*)
     * @param sql
     * @param args
     * @return
     */
    public static int getTotal(String sql,Object ... args)  {
        Connection con = null;
        PreparedStatement ps=null;
        int  total=0;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=1;i<=args.length;i++){
                    ps.setObject(i,args[i-1]);
                }
            }
         ResultSet rs = ps.executeQuery();
         if(rs.next()){
             total=rs.getInt(1);
         }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.release(null,ps,con);
        }
        return total;
    }

}
