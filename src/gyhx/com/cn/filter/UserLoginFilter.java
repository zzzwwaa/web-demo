/**package gyhx.com.cn.filter;

import gyhx.com.cn.utils.AjaxUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class UserLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    //用户没有登录过滤
    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        //获取请求的资源
        String uri = req.getRequestURI();
        //如果你是登录的业务
        if(uri.contains("/admin/login")||uri.equals("/")){
            filterChain.doFilter(request,servletResponse);
        }else{
            //从回话域里面获取当前登录的用户
            HttpSession session = req.getSession();
            Object obj = session.getAttribute("loginUser");
            //如果用户没有登录
            /**if(obj==null){
                AjaxUtils.showInfo(response,"请先登录!","/jsp/admin/login.jsp");
            }else{
                filterChain.doFilter(request,response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
        */