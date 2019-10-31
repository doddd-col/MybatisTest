package entity;

import java.util.List;

public class StudentClass {
    private int classid;
    private String classname;

    //一个班级有多个学生   增加学生属性 通过该字段让Student 和 StudentClass建立关联
    private List<Student> studentList;

    @Override
    public String toString() {
        return "StudentClass{" +
                "classid=" + classid +
                ", classname='" + classname + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
