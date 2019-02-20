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
        if (dengluService.login(denglu)){
             request.getSession().setAttribute("user",denglu);
             response.sendRedirect("../T42/index.html");   //成功要跳转T42文件的index.html
        }else {
            response.sendRedirect("T4/index.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
