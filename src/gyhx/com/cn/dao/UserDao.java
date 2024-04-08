package gyhx.com.cn.dao;

import gyhx.com.cn.model.UserModel;
import gyhx.com.cn.page.ResultPage;
import gyhx.com.cn.utils.BaseUtils;

import java.util.List;

import static gyhx.com.cn.utils.DBUtils.password;

public class UserDao {

    private static final String querySQL=" select * from user order by id desc limit ?,5";

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public UserModel queryUserById(String id){
        return BaseUtils.queryObj("select * from user where id=?",UserModel.class,id);
    }


    //登录
    public UserModel login(String name, String pwd){
        Object [] objs=new Object[]{name,pwd};
        return BaseUtils.queryObj("select * from user where name=? and password=?",UserModel.class,objs);
    }
    //查询
   public List<UserModel> queryUserByPage(int page){
       int begin =(page-1)*5;
       return BaseUtils.queryListByParam(querySQL,UserModel.class,begin);
   }
    //添加用戶
    public void insertUser(String name,String password){
        String sql="insert into user(name,password) values(?,?)";
        BaseUtils.insertOrDelete(sql,new Object[]{name,password});
    }
    //刪除用户
    public void deleteUser(int id){
        String sql="delete from user where id=?";
        BaseUtils.insertOrDelete(sql,id);
    }

    //编辑
    public boolean  updateUser(String name, int id){
        String sql="update user set name=?,password=?  where id=?";
        return BaseUtils.update(sql,new Object[]{name,password,id});
    }
    //用户分页对象设置
    public ResultPage getUserResult(int page){
        ResultPage r=new ResultPage();
        //总的数据
        r.setList(this.queryUserByPage(page));
        //当前页
        r.setPage(page);
        //总条数
        r.setCount(BaseUtils.getTotal("select count(*) from user",null));
        //总页数
        if(r.getCount()%5==0){
            r.setPageCount(r.getCount()/5);
        }else{
            r.setPageCount((r.getCount()/5)+1);
        }
        return r;
    }
    //批量删除实现G
    public void deleteBatch(String id) {
       // 10,9,5,
        id=id.substring(0,id.length()-1);

        String[] arrays = id.split(",");

        //拼接SQL语句
        String sql="delete form user where id in(";
        for(int i=0;i<arrays.length;i++){
            if(i!=arrays.length-1){
                sql+="?"+",";
            }else{
                sql+="?";
            }
        }
        sql+=")";
        System.out.println(sql);
        BaseUtils.insertOrDelete(sql,arrays);
    }

    public static void main(String[] args) {
        String id=" 10,9,5,";
        id=id.substring(0,id.length()-1);
        System.out.println(id);
    }
}
