package test;

import entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IStudentService;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring-conf.xml");
        IStudentService studentService=(IStudentService) applicationContext.getBean("studentservice");

        Student student=new Student(222,"a323dsa",42);
        studentService.addStudent(student);
    }

}
