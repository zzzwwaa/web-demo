package gyhx.com.cn.servlet.news;

import gyhx.com.cn.dao.NewDao;
import gyhx.com.cn.page.ResultPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showNews")
public class ShowNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        //获取参数
        String page=req.getParameter("page");
        //查询数据库
        NewDao newdao=new NewDao();
        int newPage=(page==null?1:Integer.parseInt(page));

        //查询数据库返回分页对象
        ResultPage newsResult = newdao.getNewsResult(newPage);


        req.setAttribute("news",newsResult);
        //响应页面
        req.getRequestDispatcher("/jsp/admin/showNews.jsp").forward(req,resp);
    }
}
