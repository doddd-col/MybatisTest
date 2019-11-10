package controller;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.StudentService;
import service.impl.StudentServiceImpl;

import java.util.Map;

@Controller//控制器 Controller层
@RequestMapping("Controller")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping("Create")
    public String Create(Student student, Map<String,Object> map){
        studentService.Create(student);
        map.put("student",student);
        return "success";
    }
}
