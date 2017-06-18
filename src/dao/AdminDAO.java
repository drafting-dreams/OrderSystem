package dao;

import vo.Admin;

/**
 * Created by Administrator on 2017/5/20.
 */
public interface AdminDAO {
    public boolean login(Admin admin) throws Exception;
}
