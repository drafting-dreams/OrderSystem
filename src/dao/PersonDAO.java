package dao;

import vo.Person;

/**
 * Created by Administrator on 2017/5/18.
 */
public interface PersonDAO {
    //做登录验证
    public boolean login(Person person) throws Exception;
    //用户注册
    public boolean regist(Person person) throws Exception;
}
