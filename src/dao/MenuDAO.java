package dao;

import vo.Menu;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */
public interface MenuDAO {
    public void insert(Menu menu) throws Exception;
    public void update(Menu menu) throws Exception;
    public void delete(String id)throws Exception;
    public Menu queryById(String id) throws Exception;
    public List queryAll() throws Exception;
    public List queryByLike(String cond) throws Exception;
}
