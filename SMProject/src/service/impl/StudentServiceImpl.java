package service.impl;

import mapper.StudentMapper;
import entity.Student;
import service.IStudentService;

public class StudentServiceImpl implements IStudentService {

    private StudentMapper mapper;

    public void setMapper(StudentMapper mapper) {
        this.mapper = mapper;
    }

    public void addStudent(Student student) {
        //调用Dao层
        mapper.addStudent(student);
    }
}
