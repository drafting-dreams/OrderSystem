package dao.impl;

import dao.AdminDAO;
import dbc.DataBaseConnection;
import vo.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 2017/5/20.
 */
public class AdminDAOImpl implements AdminDAO {
    @Override
    public boolean login(Admin admin) throws Exception {
        boolean flag = false;
        String sql="SELECT ANAME FROM admin WHERE ANO=? and PWD=?";
        DataBaseConnection dbc = new DataBaseConnection();
        try {
            Connection conn=dbc.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,admin.getId());
            pstmt.setString(2, admin.getPassWord());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                flag = true;
                admin.setName(rs.getString(1));
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
}
