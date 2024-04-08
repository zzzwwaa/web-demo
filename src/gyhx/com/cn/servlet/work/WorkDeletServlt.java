package gyhx.com.cn.servlet.work;

import gyhx.com.cn.dao.WorkDao;
import gyhx.com.cn.utils.AjaxUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteWork")
public class WorkDeletServlt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //批量删除 id=10,9,5,
        WorkDao workDao=new WorkDao();
        //如果包含了逗号
        if(id.contains(",")){
            //批量删除
            workDao.deleteBatch(id);
        }else{
            //开始调用数据库
            workDao.deleteWork(Integer.parseInt(id));
        }
        //不管成功还是失败必然要跳转到列表界面
        AjaxUtils.showInfo(resp,"删除成功 ！","/showWork");
    }
}
