package controls;

import Dao.YinyueDao;
import Dao.imp.YinyueDaoImpl;
import entity.Yinyue;
import util.YinyuePath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by LENOVO on 2019-02-24.
 */
@WebServlet(name = "YinyueServlet",urlPatterns = "/yy")
public class YinyueServlet extends HttpServlet {
    YinyueDao yinyueDao=new YinyueDaoImpl();
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
    protected void sel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Yinyue> list=yinyueDao.selectAll();

        //[{"gradeid:"1","gradename":"张三"},{},{}]
        StringBuffer newJSON=new StringBuffer("[");
        for (Yinyue g:list) {
            //newJSON.append("{\"title\":\"\",\"mp3\":\"\"},");

          //  newJSON.append("{\"title\":\"<img src='assets/images/10.jpg' alt='' /><div class='item-song'>"+g.getName()+" </div><div class='item-artist'>Dangerous Game</div>\",\"mp3\":\"yinyue%2F"+g.getDizhi()+"\"},");
            String path="yinyue/"+g.getDizhi();
           newJSON.append("{\"title\":\"<img src='assets/images/10.jpg' alt='' /><div class='item-song'>"+g.getName()+" </div><div class='item-artist'>Dangerous Game</div>\",\"mp3\":\""+path+"\"},");
        }
        String r=newJSON.substring(0,newJSON.length()-1);
        r= r+"]";
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        out.print(r);
        out.flush();
        out.close();
    }
        protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Yinyue> list=yinyueDao.selectAll();
        request.getSession().setAttribute("aa",list);
        response.sendRedirect("A1/index.jsp");
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int name= Integer.parseInt(request.getParameter("name"));
        int dizhi= Integer.parseInt(request.getParameter("dizhi"));
        Yinyue yinyue=new Yinyue();
        yinyue.setName(String.valueOf(name));
        yinyue.setDizhi(String.valueOf(dizhi));
        int a=yinyueDao.add(yinyue);
        if(a==1){
           // response.sendRedirect("yy?type=select");
        }
        PrintWriter out= response.getWriter();
        out.print(a);
        out.flush();
        out.close();


    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Yinyue y=new Yinyue();
        y.setId(Integer.parseInt(request.getParameter("id")));
        y.setName(request.getParameter("name"));
        y.setDizhi(request.getParameter("dizhi"));
        System.out.println(y);
        int x=yinyueDao.update(y);
        if (x==1){
            response.sendRedirect("yy");
              }else{ request.getRequestDispatcher("houtai/update2.jsp").forward(request,response);
        }
    }
    protected void selectByid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id= Integer.parseInt(request.getParameter("id"));
        Yinyue yinyue=yinyueDao.selectByid(id);
        request.getSession().setAttribute("info",yinyue);
        response.sendRedirect("houtai/update2.jsp");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info=request.getParameter("id");
        if(info!=null){
            int id=Integer.valueOf(info);
            int r=yinyueDao.delete(id);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
