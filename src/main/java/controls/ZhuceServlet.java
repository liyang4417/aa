package controls;

import entity.Zhuce;
import service.ZhuceService;
import service.impl.ZhuceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by LENOVO on 2019-02-21.
 */
@WebServlet(name = "ZhuceServlet",urlPatterns = "/zc")
public class ZhuceServlet extends HttpServlet {
    ZhuceService zhuceService=new ZhuceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int username= Integer.parseInt(request.getParameter("username"));
        int pwd= Integer.parseInt(request.getParameter("password"));
        Zhuce zhuce=new Zhuce();
        zhuce.setUser(username);
        zhuce.setPwd(pwd);
        System.out.println(zhuce.getUser());
        int a=zhuceService.add(zhuce);
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
