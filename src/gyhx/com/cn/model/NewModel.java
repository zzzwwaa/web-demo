package gyhx.com.cn.model;

import java.util.Date;

public class NewModel {
    private int id;
    private String name;
    private String content;
    private Date date;
    private int user_id;
    private String uname;

    public NewModel() {
    }

    public NewModel(String name, String content, int user_id, String uname) {
        this.name = name;
        this.content = content;
        this.user_id = user_id;
        this.uname = uname;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", user_id=" + user_id +
                ", uname='" + uname + '\'' +
                '}';
    }
}
