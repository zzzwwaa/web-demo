package gyhx.com.cn.servlet.news;

import gyhx.com.cn.dao.NewDao;

import gyhx.com.cn.model.NewModel;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//editUser?id=11

 /**
 * 挑战到编辑页面
  */
@WebServlet("/editNews")
public class NewsEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //查询数据库
        NewDao newDao=new NewDao();
        NewModel news = newDao.queryNewById(id);
        //返回到页面的时候携带一个用户对象
        req.setAttribute("news",news);
        //数据放在请求域并响应页面只有这种写法
        req.getRequestDispatcher("/jsp/admin/editNews.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
