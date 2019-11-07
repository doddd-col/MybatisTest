package mapper;

import entity.*;

import java.util.List;
import java.util.Map;

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

    Student querystudentByName(String name);

    List<Student> querystudentOrderByColumn(String column);

    List<Student> querystudentByNameWithHashMap(Map<String,Object> map);


    void deleteStuBysnoWithProceedure(Map<String,Object> map);

    List<Student> querystudentByNameAndAgeWithSqlTag(Student student);

    List<Student> querystudentWithGrade(Grade grade);

    List<Student> querystudentWithArray(int[] num);

    List<Student> querystudentWithList(List<Integer> list);

    List<Student> querystudentWithStuArray(Student[] students);

    StudentBusiness querystudentByBusiOO(int sno);

    Student querystudentBysnoOO(int sno);

    StudentClass queryClassStudent(int classid);

    StudentCard query(int sno);


    Student querystudentCardlazyload(int sno);

}
