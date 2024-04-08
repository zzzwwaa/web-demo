package gyhx.com.cn.servlet.member;

import gyhx.com.cn.dao.MemberDao;
import gyhx.com.cn.utils.AjaxUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet("/updateMember")
public class MemberUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("id");
        String age=req.getParameter("age");
        String name=req.getParameter("name");
        String pnum=req.getParameter("pnum");
        String lpnum=req.getParameter("lpnum");
        String create_time=req.getParameter("create_time");
        //获取图片
        /**Part file = req.getPart("file");
        String url="//img//work//"+file.getSubmittedFileName();
        file.write("D:/Java code 11/wenao"+url);*/

        MemberDao memberDao=new MemberDao();
        boolean fs = memberDao.updateMember(name,Integer.parseInt(age),lpnum,pnum,create_time,Integer.parseInt(id));
        if(fs){
            AjaxUtils.showInfo(resp,"修改成功!","/showMember");
        }else{
            AjaxUtils.showInfo(resp,"修改失败!","/showMember");
        }

    }
}
