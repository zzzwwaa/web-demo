package gyhx.com.cn.servlet.member;

import gyhx.com.cn.dao.MemberDao;
import gyhx.com.cn.page.ResultPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showMember")
public class MemberShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String page=req.getParameter("page");
        //查询数据库
        MemberDao memberdao=new MemberDao();
        int newPage=(page==null?1:Integer.parseInt(page));

        //查询数据库返回分页对象
        ResultPage memberResult = memberdao.getMemberResult(newPage);


        req.setAttribute("member",memberResult);
        //响应页面
        req.getRequestDispatcher("/jsp/admin/showMember.jsp").forward(req,resp);
    }
}
