package servlet;

import factory.DAOFactory;
import vo.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/19.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set path
        String path="register.jsp";
        //Get the parameters
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        //Copy the parameters to class vo
        Person person = new Person();
        person.setPassword(password);
        person.setId(id);
        person.setName(name);
        try{
            if(DAOFactory.getPersonDAOInstance().regist(person)){
                request.getSession().setAttribute("uname",person.getName());
                request.getSession().setAttribute("pwd",person.getPassword());
                request.getSession().setAttribute("no",person.getId());
                path="register_success.jsp";
            }else if(id!=null&&password!=null&&name!=null){
                request.setAttribute("err","注册失败" );
            }else{}
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher(path).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
