package gyhx.com.cn.dao;

import gyhx.com.cn.model.MemberModel;
import gyhx.com.cn.page.ResultPage;
import gyhx.com.cn.utils.BaseUtils;

import java.util.List;

public class MemberDao {
    private static final String querySQL=" select * from member order by id desc limit ?,5";

    public MemberModel queryMemberById(String id){
        return BaseUtils.queryObj("select * from member where id=?",MemberModel.class,id);
    }


    public List<MemberModel> queryMemberByPage(int page){
        int begin =(page-1)*5;
        return BaseUtils.queryListByParam(querySQL,MemberModel.class,begin);
    }

    //添加用戶
        public void insertMember(MemberModel wm){
            String sql="insert into member(name,image,age,lpnum,create_time,pnum) values(?,?,?,?,?,?)";
            BaseUtils.insertOrDelete(sql,new Object[]{wm.getName(),wm.getImage(),wm.getAge(),wm.getPnum(),wm.getLpnum(),wm.getCreate_time()});
        }
    public void deleteMember(int id){
        String sql="delete from member where id=?";
        BaseUtils.insertOrDelete(sql,id);
    }
    public boolean  updateMember(String name, int age, String pnum, String id, String lpnum, int create_time){
        String sql="update member set name=?, age=?, pnum=?,lpnum=?,create_time=?  where id=?";
        return BaseUtils.update(sql,new Object[]{name,age,pnum,id,lpnum,create_time});
    }


    public ResultPage<MemberModel> getMemberResult(int page){
        ResultPage<MemberModel> r=new ResultPage<MemberModel>();

        List<MemberModel> mList= this.queryMemberByPage(page);
        System.out.println(mList);
        //总的数据
        r.setList(mList);
        //当前页
        r.setPage(page);
        //总条数
        r.setCount(BaseUtils.getTotal("select count(*) from member",null));
        //总页数
        if(r.getCount()%5==0){
            r.setPageCount(r.getCount()/5);
        }else{
            r.setPageCount((r.getCount()/5)+1);
        }
        return r;
    }
    public void deleteBatch(String id) {
        // 10,9,5,
        id=id.substring(0,id.length()-1);

        String[] arrays = id.split(",");

        //拼接SQL语句
        String sql="delete form member where id in(";
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

