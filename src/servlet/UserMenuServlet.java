package servlet;

import factory.DAOFactory;
import vo.Menu;
import vo.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */
public class UserMenuServlet extends HttpServlet {
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
        if (status.equals("selectall")) {
            try {
                req.setAttribute("all", DAOFactory.getMenuDAOInstance().queryAll());
            } catch (Exception e) {
                e.printStackTrace();
            }
            path="user_menu.jsp";
        }
        if (status.equals("insert")) {
            List menu=new ArrayList();
            try {
               menu= DAOFactory.getMenuDAOInstance().queryAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Iterator iter=menu.iterator();
            java.util.Date utilDate=new java.util.Date();
            boolean flag=false;
            String uid = (String) req.getSession().getAttribute("uid");
            while(iter.hasNext()) {
                Menu menu1 = (Menu)iter.next();

                String mid=req.getParameter(menu1.getId());
                String mname=req.getParameter(menu1.getName());
                String num=req.getParameter(mname+"number");
                String price = req.getParameter(mname + "price");
                SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
                String oid=format.format(utilDate)+req.getParameter(mname+"index");
                if(mid!=null&&!num.equals("0")&&num!=null&&!num.equals("")) {
                    Order order = new Order();
                    order.setState(false);
                    order.setNum(Integer.parseInt(num));
                    order.setDate(utilDate);
                    order.setMenuName(mname);
                    order.setUserId(uid);
                    order.setMoney(Float.parseFloat(price)*Float.parseFloat(num));
                    order.setId(oid);
                    try {
                        DAOFactory.getOrderDAOInstance().insert(order);
                        flag=true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
            try {
                req.setAttribute("all",DAOFactory.getOrderDAOInstance().queryByUserId(uid));
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.setAttribute("flag",new Boolean(flag));
            path="insert_do.jsp";
        }else{
            //非法请求
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }
}
