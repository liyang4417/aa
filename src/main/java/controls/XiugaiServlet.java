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
import java.util.List;

/**
 * Created by LENOVO on 2019-02-23.
 */
@WebServlet(name = "XiugaiServlet",urlPatterns = "/xg")
public class XiugaiServlet extends HttpServlet {
    ZhuceService zhuceService=new ZhuceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type=request.getParameter("type");
        if (type!=null && "sel".equals(type)){
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
        }else if (type!=null && "update".equals(type)){
            update(request,response);
        }
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Zhuce zhuce=new Zhuce();
        zhuce.setId(Integer.valueOf(request.getParameter("id")));
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
