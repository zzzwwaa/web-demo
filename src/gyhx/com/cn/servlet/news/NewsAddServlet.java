package gyhx.com.cn.servlet.news;

import gyhx.com.cn.dao.NewDao;
import gyhx.com.cn.model.NewModel;
import gyhx.com.cn.model.UserModel;
import gyhx.com.cn.utils.AjaxUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/admin/addNews")
public class NewsAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String content = req.getParameter("content");
        UserModel user = AjaxUtils.getSessionKey(req);

        NewModel newModel=new NewModel(name,content,user.getId(),user.getName());
         //保存到数据库
        NewDao newDao=new NewDao();
        newDao.insertNews(newModel);

        //返回到列表界面....
        AjaxUtils.showInfo(resp,"添加成功!","/showNews");
    }
}
