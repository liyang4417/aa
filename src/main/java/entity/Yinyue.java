package entity;

import java.io.Serializable;

/**
 * Created by LENOVO on 2019-02-20.
 */
public class Yinyue implements Serializable {
    private int id;
    private String name;
    private String dizhi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    @Override
    public String toString() {
        return "Yinyue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dizhi='" + dizhi + '\'' +
                '}';
    }
}
