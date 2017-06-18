package dao.impl;

import dao.MenuDAO;
import dbc.DataBaseConnection;
import vo.Menu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public class MenuDAOImpl implements MenuDAO {
    @Override
    public void insert(Menu menu) throws Exception {
        String sql="INSERT INTO menu VALUES(?,?,?)";
        PreparedStatement pstmt=null;
        DataBaseConnection dbc = null;
        dbc=new DataBaseConnection();
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1, menu.getId());
            pstmt.setString(2, menu.getName());
            pstmt.setFloat(3, menu.getPrice());
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
    public void update(Menu menu) throws Exception {
        String sql="UPDATE menu SET MNAME=?, PRICE=? WHERE MNO=?";
        PreparedStatement pstmt=null;
        DataBaseConnection dbc = null;
        dbc=new DataBaseConnection();
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1, menu.getName());
            pstmt.setFloat(2, menu.getPrice());
            pstmt.setString(3, menu.getId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("操作出现错误！！！");
        }finally {
            dbc.close();
        }
    }

    @Override
    public void delete(String id) throws Exception {
        String sql="DELETE FROM menu WHERE MNO=?";
        PreparedStatement pstmt=null;
        DataBaseConnection dbc = null;
        dbc=new DataBaseConnection();
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("操作出现错误！！！");
        }finally {
            dbc.close();
        }
    }

    @Override
    public Menu queryById(String id) throws Exception {
        Menu menu=null;
        String sql="SELECT MNO, MNAME, PRICE FROM menu WHERE MNO=?";
        PreparedStatement pstmt=null;
        DataBaseConnection dbc = null;
        dbc=new DataBaseConnection();
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs= pstmt.executeQuery();
            if (rs.next()) {
                menu = new Menu();
                menu.setId(rs.getString(1));
                menu.setName(rs.getString(2));
                menu.setPrice(rs.getFloat(3));
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("操作出现错误！！！");
        }finally {
            dbc.close();
        }
        return menu;
    }

    @Override
    public List queryAll() throws Exception {
        List all = new ArrayList();
        String sql="SELECT * FROM menu";
        PreparedStatement pstmt=null;
        DataBaseConnection dbc = null;
        dbc=new DataBaseConnection();
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setId(rs.getString(1));
                menu.setName(rs.getString(2));
                menu.setPrice(rs.getFloat(3));
                all.add(menu);
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

    @Override
    public List queryByLike(String cond) throws Exception {
        List all = new ArrayList();
        String sql="SELECT * FROM menu WHERE MNAME LIKE ?";
        PreparedStatement pstmt=null;
        DataBaseConnection dbc = null;
        dbc=new DataBaseConnection();
        try {
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1, "%" + cond + "%");
            ResultSet rs= pstmt.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setId(rs.getString(1));
                menu.setName(rs.getString(2));
                menu.setPrice(rs.getFloat(3));
                all.add(menu);
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
