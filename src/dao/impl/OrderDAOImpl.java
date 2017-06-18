package dao.impl;

import dao.OrderDAO;
import dbc.DataBaseConnection;
import vo.Menu;
import vo.Order;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */
public class OrderDAOImpl implements OrderDAO {
    @Override
    public void changeState(Order order) throws Exception {
        if(!order.isDealed())
            order.setState(true);
    }

    @Override
    public void insert(Order order) throws Exception {
        String sql="INSERT INTO ordert (NUM,id,MNAME,STATE,DATE,MONEY,ONO) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstmt=null;
        DataBaseConnection dbc = null;
        dbc=new DataBaseConnection();
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setInt(1, order.getNum());
            pstmt.setString(2, order.getUserId());
            pstmt.setString(3, order.getMenuName());
            pstmt.setBoolean(4,order.isDealed());
            java.sql.Date sqlDate=new java.sql.Date(order.getDate().getTime());
            pstmt.setDate(5, sqlDate);
            pstmt.setFloat(6,order.getMoney());
            pstmt.setString(7,order.getId());
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("操作出现错误！！！");
        }finally {
            dbc.close();
        }
    }

    @Override
    public List queryByUserId(String id) throws Exception {
        List all = new ArrayList();
        String sql="SELECT * FROM ordert WHERE id=?";
        PreparedStatement pstmt=null;
        DataBaseConnection dbc = null;
        dbc=new DataBaseConnection();
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs= pstmt.executeQuery();
            while (rs.next()) {
                Order order=new Order();
                order.setId(rs.getString(1));
                order.setNum(rs.getInt(2));
                order.setUserId(rs.getString(3));
                order.setMenuName(rs.getString(4));
                order.setState(rs.getBoolean(5));
                order.setDate(rs.getDate(6));
                order.setMoney(rs.getFloat(7));
                all.add(order);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("操作出现错误！！！");
        }finally {
            dbc.close();
        }
        return all;
    }
}
