package entity;

import java.io.Serializable;

/**
 * Created by LENOVO on 2019-02-21.
 */
public class Zhuce implements Serializable {
    private int id;
    private int pwd;
    private int user;

    public Zhuce() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
