package service.impl;

import entity.Student;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StudentService;

@Service//将该类添加到IOC容器中
public class StudentServiceImpl implements StudentService {
    //依赖注入
   @Autowired//自动装配 （根据该类型在IOC容器中自动寻找）  还有@Qualifier("xxx")根据名字装配
    StudentMapper mapper;
    @Override
    public void Create(Student student) {
        mapper.Create(student);
    }
}
