package com.hrms.test;

import com.hrms.bean.Department;
import com.hrms.mapper.DepartmentMapper;
import com.hrms.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * @author doddd
 * @date 2019/11/19-9:08
 **/

@Service
public class CRUDTest {
   @Autowired
    private DepartmentMapper departmentMapper;


//    public void CRUD(){
//
//        System.out.println(departmentMapper);
//    }
//
//    public static void main(String[] args) {
//        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:WEB-INF/applicationContext.xml");
//        DepartmentMapper bean = applicationContext.getBean(DepartmentMapper.class);
//        System.out.println(bean);
//        Department department = bean.selectByPrimaryKey(new Long(1));
//        System.out.println(department);
//        CRUDTest crudTest=new CRUDTest();
//        crudTest.CRUD();
//
//
//    }
}
