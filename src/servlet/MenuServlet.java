package servlet;

import factory.DAOFactory;
import vo.Menu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/21.
 */
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String path = "errors.jsp";
        //接收要操作的参数值
        String status = req.getParameter("status");
        if (status != null) {
            //参数有内容，之后选择合适的方法
            //查询全部操作
            if (status.equals("selectall")) {
                try {
                    req.setAttribute("all", DAOFactory.getMenuDAOInstance().queryAll());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                path="menu_management.jsp";
            }
            if (status.equals("insert")) {
                //1.接收插入信息
                String id=req.getParameter("mno");
                String name=req.getParameter("mname");
                String  price = req.getParameter("mprice");
                //2.实例化VO对象
                Menu menu= new Menu();
                menu.setId(id);
                menu.setName(name);
                menu.setPrice(Float.parseFloat(price));
                //3.调用DAO完成数据库的插入操作
                boolean flag=false;
                try {
                     DAOFactory.getMenuDAOInstance().insert(menu);
                     flag=true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                req.setAttribute("flag",new Boolean(flag));
                path="insert_do.jsp";
            }
            if (status.equals("selectid")) {
                //接收参数
                String id=null;
                try {
                    id = req.getParameter("id");
                } catch (Exception e) {
                    e.printStackTrace();
                }try{
                    req.setAttribute("menu",DAOFactory.getMenuDAOInstance().queryById(id));
                }catch(Exception e){
                    e.printStackTrace();
                }
                path = "update.jsp";
            }
            if(status.equals("update")){
                String id=null;
                try {
                    id = req.getParameter("mno");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String name = req.getParameter("mname");
                String price = req.getParameter("mprice");
                Menu menu= new Menu();
                menu.setId(id);
                menu.setName(name);
                menu.setPrice(Float.parseFloat(price));
                boolean flag=false;
                try {
                    DAOFactory.getMenuDAOInstance().update(menu);
                    flag=true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                req.setAttribute("flag",new Boolean(flag));
                path="update_do.jsp";
            }
            if (status.equals("selectbylike")) {
                String keyword = req.getParameter("keyword");
                try {
                    req.setAttribute("all", DAOFactory.getMenuDAOInstance().queryByLike(keyword));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                path = "menu_management.jsp";
            }
            if (status.equals("delete")) {
                String id=null;
                try {
                    id = req.getParameter("id");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                boolean flag=false;
                try {
                    DAOFactory.getMenuDAOInstance().delete(id);
                    flag=true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                req.setAttribute("flag",new Boolean(flag));
                path="delete_do.jsp";
            }
        }else{
            //表示无参数，非法的客户请求
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }
}
