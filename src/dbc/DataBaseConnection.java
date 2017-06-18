package dbc;

/**
 * Created by Administrator on 2017/5/18.
 */
import java.sql.*;
public class DataBaseConnection{
    private String DBDRIVER="com.mysql.jdbc.Driver";
    private String DBURL = "jdbc:mysql://127.0.0.1:3306/message";
    private String USER = "root";
    private String PASSWORD = "root";
    private Connection conn = null;
    public DataBaseConnection(){
        try{
            Class.forName(DBDRIVER);
            this.conn=DriverManager.getConnection(DBURL,USER,PASSWORD);
        }catch(Exception e){e.printStackTrace();}
    }
    public Connection getConnection(){
        return this.conn;
    }
    public void close(){
        try{
            this.conn.close();
        }catch(Exception e){}
    }
}
