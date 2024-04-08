package gyhx.com.cn.model;

import java.util.Date;

public class WorkModel {
    private int id;
    private String name;
    private String image;
    private String content;
    private Date date;
    private int user_id;
    private String uname;

    public WorkModel() {
    }

    public WorkModel(String name, String image, String content,  int user_id,String uname) {
        this.name = name;
        this.image = image;
        this.content = content;
        this.user_id = user_id;
        this.uname=uname;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        return "WorkModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", user_id=" + user_id +
                ", uname='" + uname + '\'' +
                '}';
    }
}
