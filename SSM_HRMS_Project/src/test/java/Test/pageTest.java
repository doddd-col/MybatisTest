package Test;

import com.github.pagehelper.PageInfo;
import com.hrms.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author doddd
 * @date 2019/11/19-14:34
 *
 * spring单元测试
 * PageHelper
 **/


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:WEB-INF/applicationContext.xml","classpath:WEB-INF/dispatcher-servlet.xml"})
public class pageTest {
//    传入Springmvc的ioc
    @Autowired
    WebApplicationContext webApplicationContext;
//    虚拟mvc请求 获取处理结果
    MockMvc mockMvc;

    @Before
    public  void initMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
@Test
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("SSM_HRMS_Project_war_exploded/EmployeeController/getPagings").param("pn", "1")).andReturn();

//        拿出pageInfo
        MockHttpServletRequest request = mvcResult.getRequest();
        PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
        System.out.println("当前页码:"+pageInfo.getPageNum());
        System.out.println("总页码:"+pageInfo.getPages());
        System.out.println("总记录数："+pageInfo.getTotal());
        System.out.println("连续显示的页面：");
        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        for (int i = 0; i < navigatepageNums.length; i++) {
            System.out.println(navigatepageNums[i]);
        }
//        获取员工数据
        List<Employee> list = pageInfo.getList();
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

}
