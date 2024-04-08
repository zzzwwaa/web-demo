package gyhx.com.cn.servlet.member;

import gyhx.com.cn.dao.MemberDao;
import gyhx.com.cn.model.MemberModel;
import gyhx.com.cn.utils.AjaxUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
@WebServlet("/addMember")
@MultipartConfig
public class MemberAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求的name
        String name=req.getParameter("name");
        String age=req.getParameter("age");
        String lpnum=req.getParameter("lpnum");
        String pnum=req.getParameter("pnum");
        String create_time=req.getParameter("create_time");
        //获取图片
        Part file = req.getPart("file");
        String url="/img/work/"+file.getSubmittedFileName();
        file.write("D:/Java code 11/wenao"+url);
        //获取登录的用户
        //UserModel user = AjaxUtils.getSessionKey(req);
        //拼装作品对象
        MemberModel member=new MemberModel(name,url,Integer.parseInt(age),lpnum,pnum,create_time);
        //保存作品对象
        MemberDao memberDao=new MemberDao();

        memberDao.insertMember(member);

        AjaxUtils.showInfo(resp,"添加成功!","/showMember");

    }
}
