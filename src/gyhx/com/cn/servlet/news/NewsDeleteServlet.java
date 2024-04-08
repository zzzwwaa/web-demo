package gyhx.com.cn.servlet.news;

import gyhx.com.cn.dao.NewDao;
import gyhx.com.cn.utils.AjaxUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteNews")
public class NewsDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //批量删除 id=10,9,5,
        NewDao newDao=new NewDao();
        //如果包含了逗号
        if(id.contains(",")){
            //批量删除
            newDao.deleteBatch(id);
        }else{
            //开始调用数据库
            newDao.deleteNews(Integer.parseInt(id));
        }
        //不管成功还是失败必然要跳转到列表界面
        AjaxUtils.showInfo(resp,"删除成功 ！","/showNews");
    }
}
