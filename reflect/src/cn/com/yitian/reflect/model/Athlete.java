package cn.com.yitian.reflect.model;

public class Athlete {
    private Integer id;
    private String sname;
    private String sex;
    private String phone;
    private Integer age;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
