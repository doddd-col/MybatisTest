package org.entity;

public class Student {
    private Integer sno;

    private String name;

    private Integer age;

    private Short sex;

    private String homeaddrss;

    private String schooladdrss;

    private Short cardid;

    private Short classid;

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getHomeaddrss() {
        return homeaddrss;
    }

    public void setHomeaddrss(String homeaddrss) {
        this.homeaddrss = homeaddrss == null ? null : homeaddrss.trim();
    }

    public String getSchooladdrss() {
        return schooladdrss;
    }

    public void setSchooladdrss(String schooladdrss) {
        this.schooladdrss = schooladdrss == null ? null : schooladdrss.trim();
    }

    public Short getCardid() {
        return cardid;
    }

    public void setCardid(Short cardid) {
        this.cardid = cardid;
    }

    public Short getClassid() {
        return classid;
    }

    public void setClassid(Short classid) {
        this.classid = classid;
    }
}