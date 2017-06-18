package vo;

import java.util.Date;


/**
 * Created by Administrator on 2017/5/20.
 */
public class Order {
    private String id;
    private String  menuName;
    private int num;
    private float money;
    private String userId;
    private boolean dealed;
    private java.util.Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isDealed() {
        return dealed;
    }

    public void setState(boolean dealed) {
        this.dealed = dealed;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
