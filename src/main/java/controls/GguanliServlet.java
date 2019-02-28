package controls;

import service.guanliService;
import service.impl.guanliServiceImpl;
import entity.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by LENOVO on 2019-02-27.
 */
@WebServlet(name = "GguanliServlet",urlPatterns = "/gl")
public class GguanliServlet extends HttpServlet {
    guanliService guanliService=new guanliServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        if (type==null||type.equals("select")){
            select(request,response);
        }else if (type.equals("add")){
            add(request,response);
        }else if (type.equals("delete")){
            delete(request,response);
        }else if (type.equals("selectByid")) {
            selectByid(request, response);
        } else if (type.equals("update")) {
            update(request,response);
        }else if(type.equals("select")){
            select(request,response);
        }
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int username= Integer.parseInt(request.getParameter("username"));
        int pwd= Integer.parseInt(request.getParameter("password"));
         guanli guanli=new guanli();
//        guanli.setName(username);
//        guanli.setPwd(pwd);
        int a=guanliService.add(guanli);
        String used="false";
        if(a==1){
            used="true";
        }
        PrintWriter out=response.getWriter();
        out.print(used);
        out.flush();
        out.close();
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void selectByid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
