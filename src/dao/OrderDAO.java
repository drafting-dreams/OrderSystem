package dao;

import vo.Order;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */
public interface OrderDAO {
    public void changeState(Order order)throws Exception;
    public void insert(Order order)throws Exception;
    public List queryByUserId(String id)throws Exception;
}
