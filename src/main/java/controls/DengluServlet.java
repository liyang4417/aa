package controls;

import entity.Denglu;
import service.DengluService;
import service.impl.DengluServiceImpl;

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
 * Created by LENOVO on 2019-01-04.
 */
@WebServlet(name = "DengluServlet",urlPatterns = "/denglu")
public class DengluServlet extends HttpServlet {
    DengluService dengluService=new DengluServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("utf-8");
        int username= Integer.parseInt(request.getParameter("username"));
        int password= Integer.parseInt(request.getParameter("password"));
        Denglu denglu=new Denglu();
        denglu.setUser(username);
        denglu.setPwd(password);
        String used="false";
        if(dengluService.login(denglu)){
            used="true";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.print(used);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
