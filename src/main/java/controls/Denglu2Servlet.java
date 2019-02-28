package controls;

import entity.*;
import service.DengluService;
import service.impl.DengluServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by LENOVO on 2019-02-27.
 */
@WebServlet(name = "Denglu2Servlet",urlPatterns = "/htdl")
public class Denglu2Servlet extends HttpServlet {
    DengluService dengluService=new DengluServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type=request.getParameter("type");
        if (type==null||type.equals("select")){
            select(request,response);
        }else if (type.equals("add")){
            add(request,response);
        }

    }
    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        guanli guanl=new guanli();
        guanl.setName(username);
        guanl.setPwd(password);
        String used="false";
        if(dengluService.tt(guanl)){
            used="true";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.print(used);
        out.flush();
        out.close();
    }  protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String user=request.getParameter("username");
        System.out.println(user);
        String pwd=request.getParameter("password");
        System.out.println(pwd);
        guanli guanl=new guanli();
        guanl.setName(user);
        guanl.setPwd(pwd);
        int a=dengluService.add(guanl);
        String used="false";
        if(a==1){
            used="true";
        }
        PrintWriter out=response.getWriter();
        out.print(used);
        out.flush();
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
