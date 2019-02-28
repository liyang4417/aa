package controls;

import Dao.ChaxunDao;
import Dao.YinyueDao;
import Dao.imp.ChaxunDaoImpl;
import Dao.imp.YinyueDaoImpl;
import entity.Denglu;
import entity.Yinyue;

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
@WebServlet(name = "AllServlet",urlPatterns = "/all")
public class AllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        YinyueDao yinyueDao=new YinyueDaoImpl();
        ChaxunDao chaxunDao=new ChaxunDaoImpl();
        List<Yinyue> aa=yinyueDao.selectAll();
        request.getSession().setAttribute("aa",aa);
        List<Denglu> list=chaxunDao.selectAll();
        request.getSession().setAttribute("list",list);
        response.sendRedirect("A1/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
