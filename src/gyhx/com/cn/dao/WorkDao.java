package gyhx.com.cn.dao;


import gyhx.com.cn.model.WorkModel;
import gyhx.com.cn.page.ResultPage;
import gyhx.com.cn.utils.BaseUtils;

import java.util.List;

public class WorkDao {
    //添加用戶
    public void insertWork(WorkModel wm){
        String sql="insert into work(name,image,content,date,user_id,uname) values(?,?,?,now(),?,?)";
        BaseUtils.insertOrDelete(sql,new Object[]{wm.getName(),wm.getImage(),wm.getContent(),wm.getUser_id(),wm.getName()});
    }
    private static final String querySQL=" select * from work order by id desc limit ?,5";

 /**
     * 根据id查询用户
     * @param id
     * @return */

    public WorkModel queryWorkById(String id){
        return BaseUtils.queryObj("select * from work where id=?",WorkModel.class,id);
    }

    //查询
    public List<WorkModel> queryWorkByPage(int page){
        int begin =(page-1)*5;
        return BaseUtils.queryListByParam(querySQL,WorkModel.class,begin);
    }

    //刪除用户
    public void deleteWork(int id){
        String sql="delete from work where id=?";
        BaseUtils.insertOrDelete(sql,id);
    }

    //编辑
    public boolean  updateWork(String name,String URL,String content,int id){
        String sql="update work set name=?,  image=?, content=?  where id=?";
        return BaseUtils.update(sql,new Object[]{name,URL,content,id});
    }
    //用户分页对象设置
    public ResultPage getWorkResult(int page){
        ResultPage r=new ResultPage();
        //总的数据
        r.setList(this.queryWorkByPage(page));
        //当前页
        r.setPage(page);
        //总条数
        r.setCount(BaseUtils.getTotal("select count(*) from work",null));
        //总页数
        if(r.getCount()%5==0){
            r.setPageCount(r.getCount()/5);
        }else{
            r.setPageCount((r.getCount()/5)+1);
        }
        return r;
    }
    //批量删除实现
    public void deleteBatch(String id) {
        // 10,9,5,
        id=id.substring(0,id.length()-1);

        String[] arrays = id.split(",");

        //拼接SQL语句
        String sql="delete from work where id in(";
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
