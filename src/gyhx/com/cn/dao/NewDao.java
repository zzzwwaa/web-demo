package gyhx.com.cn.dao;

import gyhx.com.cn.model.NewModel;
import gyhx.com.cn.page.ResultPage;
import gyhx.com.cn.utils.BaseUtils;

import java.util.List;

public class NewDao {

    private static final String querySQL=" select * from news order by id desc limit ?,5";

 /**
     * 根据id查询用户
     * @param id
     * @return        */

    public NewModel queryNewById(String id){
        return BaseUtils.queryObj("select * from news where id=?",NewModel.class,id);
    }

    public List<NewModel> queryNewByPage(int page){
        int begin =(page-1)*5;
        return BaseUtils.queryListByParam(querySQL,NewModel.class,begin);
    }

    //添加用戶
    public void insertNews(NewModel news){
        String sql="insert into news(name,content,date,user_id,uname) values(?,?,now(),?,?)";
        BaseUtils.insertOrDelete(sql,new Object[]{news.getName(),news.getContent(),news.getUser_id(),news.getUname()});
    }
    //刪除用户
    public void deleteNews(int id){
        String sql="delete from news where id=?";
        BaseUtils.insertOrDelete(sql,id);
    }

    //编辑
       public boolean  updateNews(String name,String content,int id){
        String sql="update news set name=? , content=? where id = ?";
        return BaseUtils.update(sql,new Object[]{name,content,id});
    }
    //用户分页对象设置
        public ResultPage<NewModel> getNewsResult(int page){
        ResultPage<NewModel> r=new ResultPage<NewModel>();

        List<NewModel> nList= this.queryNewByPage(page);
        System.out.println(nList);
        //总的数据
        r.setList(nList);
        //当前页
        r.setPage(page);
        //总条数
        r.setCount(BaseUtils.getTotal("select count(*) from news",null));
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
        String sql="delete form news where id in(";
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
