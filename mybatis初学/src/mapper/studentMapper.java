package mapper;

import entity.Student;

import java.util.List;

//接口名=namespace名 方法名=id值 参数=parametertype值 返回类型=resulttype
public interface studentMapper {
    void addstudent(Student student);

    void updatestudent(Student student);

    void deletestudent(int sno);

    List<Student> querystudentall();

    Student querystudentBySno(int sno);

    Student querystudentBySnoWithConverter(int sno);

    void addstudentWithConverter(Student student);

    List<Student> querystudentallWithConverter();
}
