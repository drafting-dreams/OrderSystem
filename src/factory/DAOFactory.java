package factory;

import dao.AdminDAO;
import dao.MenuDAO;
import dao.OrderDAO;
import dao.PersonDAO;
import dao.impl.AdminDAOImpl;
import dao.impl.OrderDAOImpl;
import dao.impl.PersonDAOImpl;
import dao.impl.MenuDAOImpl;

/**
 * Created by Administrator on 2017/5/18.
 */
public class DAOFactory {
    public static PersonDAO getPersonDAOInstance(){
        PersonDAOImpl person= new PersonDAOImpl();
        return person;
    }
    public static AdminDAO getAdminDAOInstance(){
        AdminDAOImpl admin = new AdminDAOImpl();
        return admin;
    }
    public static MenuDAO getMenuDAOInstance(){
        MenuDAOImpl menu = new MenuDAOImpl();
        return menu;
    }
    public static OrderDAO getOrderDAOInstance(){
        OrderDAOImpl order = new OrderDAOImpl();
        return order;
    }
}
