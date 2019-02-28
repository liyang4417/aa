package controls;

import Dao.ChaxunDao;
import Dao.imp.ChaxunDaoImpl;
import entity.Denglu;
import entity.*;
import service.ZhuceService;
import service.impl.ZhuceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2019-02-22.
 */
@WebServlet(name = "ChaxunServlet",urlPatterns = "/cx")
public class ChaxunServlet extends HttpServlet {
    ChaxunDao chaxunDao=new ChaxunDaoImpl();
    ZhuceService zhuceService=new ZhuceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type=request.getParameter("type");
        System.out.println(type);
        if (type==null||type.equals("sel")){
            sel(request,response);
        }else if (type.equals("add")){
            add(request,response);
        }else if (type.equals("delete")){
            delete(request,response);
        }else if (type.equals("selectByid")) {
            Integer id= Integer.valueOf(request.getParameter("id"));
            List<Zhuce> list=zhuceService.selectByid(id);
            StringBuffer newJSON=new StringBuffer("[");
            for (Zhuce g:list) {
                newJSON.append("{\"id\":\""+g.getId()+"\",\"user\":\""+g.getUser()+"\",\"pwd\":\"" +g.getPwd()+"\"}");
            }
            String r=newJSON.substring(0,newJSON.length()-1);
            r= r+"}]";
            System.out.println(r);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out= response.getWriter();
            out.print(r);
            out.flush();
            out.close();

        } else if (type.equals("update")) {
            update(request,response);
        }else if(type.equals("bofang")){
            sel(request,response);
        }

    }

    protected void sel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Denglu> list=chaxunDao.selectAll();
        request.getSession().setAttribute("list",list);
        response.sendRedirect("A1/index.jsp");
//        response.sendRedirect("houtai/index.jsp");

      /*  PrintWriter o= response.getWriter();
        String x= JSON.toJSONString(list);
        o.print(x);
        o.flush();
        o.close();*/
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int username= Integer.parseInt(request.getParameter("username"));
        int pwd= Integer.parseInt(request.getParameter("password"));
        Denglu denglu=new Denglu();
        denglu.setUser(username);
        denglu.setPwd(pwd);
       int a=chaxunDao.add(denglu);
        String used="false";
        if(a==1){
            used="true";
        }
        PrintWriter out=response.getWriter();
        out.print(used);
        out.flush();
        out.close();

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info=request.getParameter("id");
        if(info!=null){
            int id=Integer.valueOf(info);
            int r=chaxunDao.delete(id);
            boolean isok=false;
            if(r==1){
                isok=true;
            }
            PrintWriter out= response.getWriter();
            out.print(isok);
            out.flush();
            out.close();
        }
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Zhuce zhuce=new Zhuce();
        zhuce.setId(Integer.parseInt(request.getParameter("id")));
        zhuce.setUser(Integer.valueOf(request.getParameter("zhanghao")));
        zhuce.setPwd(Integer.valueOf(request.getParameter("mima")));
        int x=zhuceService.Update(zhuce);
        if (x==1){
            response.setContentType("text/html;charset=UTF-8");
            response.sendRedirect("cx?type=sel");
        }else{
            request.getRequestDispatcher("houtai/update.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
