package entity;

public class Student {
    private int sno;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.sno = id;
        this.name = name;
        this.age = age;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
