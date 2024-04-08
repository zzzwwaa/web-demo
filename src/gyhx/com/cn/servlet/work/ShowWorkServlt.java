package gyhx.com.cn.servlet.work;

import gyhx.com.cn.dao.WorkDao;
import gyhx.com.cn.page.ResultPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showWork")
public class ShowWorkServlt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取参数
        String page=req.getParameter("page");
        //查询数据库
        WorkDao workDao=new WorkDao();
        int newPage=(page==null?1:Integer.parseInt(page));

        //查询数据库返回分页对象
        ResultPage workResult = workDao.getWorkResult(newPage);

        req.setAttribute("work",workResult);
        //响应页
        req.getRequestDispatcher("/jsp/admin/showWork.jsp").forward(req,resp);
    }
}
