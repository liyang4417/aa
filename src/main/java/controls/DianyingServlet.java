package controls;

import entity.Dianying;
import service.DianyingService;
import service.impl.DianyingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LENOVO on 2019-02-27.
 */
@WebServlet(name = "DianyingServlet",urlPatterns = "/dy")
public class DianyingServlet extends HttpServlet {
      DianyingService dianyingService=new DianyingServiceImpl();
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
        }else if(type.equals("bofang")){
            sel(request,response);
        }
    }

    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dianying> list=dianyingService.selectAll();
        request.getSession().setAttribute("info",list);
        System.out.println(list.get(0).getDdizhi());
        response.sendRedirect("T53/index.jsp");
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void selectByid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void sel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
