 package gyhx.com.cn.model;

public class MemberModel {


    public MemberModel(String name, String url, int parseInt, String lpnum, String pnum, String create_time) {
    }

    @Override
    public String toString() {
        return "MemberModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", age=" + age +
                ", lpnum='" + lpnum + '\'' +
                ", pnum='" + pnum + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }

    public MemberModel(int id, String name, String image, int age, String lpnum, String pnum, String create_time) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.age = age;
        this.lpnum = lpnum;
        this.pnum = pnum;
        this.create_time = create_time;
    }
    private int id;
    private String name;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLpnum() {
        return lpnum;
    }

    public void setLpnum(String lpnum) {
        this.lpnum = lpnum;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    private String image;
    private int age;
    private String lpnum;
    private String pnum;
    private String create_time;
}

   /** public MemberModel(){

    }

    public MemberModel(String name, String image, int age, String work) {
        this.name = name;
        this.image = image;
        this.age = age;
        this.work = work;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "MemberModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                '}';
    }
}
*/