package Test;

import com.hrms.bean.Employee;
import com.hrms.mapper.DepartmentMapper;
import com.hrms.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author doddd
 * @date 2019/11/19-13:36
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/applicationContext.xml")
public class CRUDtest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

@Test
    public void test(){
//        System.out.println(departmentMapper);
        for (int i = 1; i < 200; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5);
            Employee employee=new Employee();
            employee.setEmpName(uid);
            employee.setEmail( uid+"@qq.com");
            employee.setGender(i%2==0?"F":"M");
            employee.setDeptId(2);
            employeeMapper.insert(employee);
        }
    }


    public static void main(String[] args) {
//        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        EmployeeMapper bean = applicationContext.getBean(EmployeeMapper.class);
//        System.out.println(bean);
        CRUDtest cruDtest = new CRUDtest();
        cruDtest.test();


    }
}
