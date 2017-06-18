package dao.impl;

import dao.PersonDAO;
import dbc.DataBaseConnection;
import vo.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Created by Administrator on 2017/5/18.
 */
public class PersonDAOImpl implements PersonDAO {
    /**
     * function:To determine whether the user name and the password is correct.
     * @param person
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean login(Person person) throws Exception {
        boolean flag = false;
        String sql="SELECT name FROM person WHERE id=? and password=?";
        DataBaseConnection dbc = new DataBaseConnection();
        try {
            Connection conn=dbc.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, person.getId());
            pstmt.setString(2, person.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                flag = true;
                person.setName(rs.getString(1));
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("操作出现错误！！！");
        }finally{
            dbc.close();
        }
        return flag;
    }

    @Override
    public boolean regist(Person person) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO person VALUES(?,?,?) ";
        DataBaseConnection dbc = new DataBaseConnection();
        try {
            Connection conn = dbc.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, person.getId());
            pstmt.setString(2, person.getName());
            pstmt.setString(3, person.getPassword());
            if(person.getId()!=null) {
                pstmt.execute();
                flag = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("操作发生错误！");
        }finally {
            dbc.close();
        }
        return flag;
    }
}
