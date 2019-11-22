package com.hrms.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hrms.bean.Employee;
import com.hrms.service.EmployeeService;
import com.hrms.utils.JsonMsg;
import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author doddd
 * @date 2019/11/19-10:24
 **/

@Controller
@RequestMapping("EmployeeController")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
    * @Description: 获取分页数据
    * @Param: [pageNumber]
    * @return: com.hrms.utils.JsonMsg
    * @Author: doddd
    * @Date: 2019/11/19
    */
    @RequestMapping(value = "getEmps",method = RequestMethod.GET)
    @ResponseBody
    public JsonMsg getEmps(@RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber){
        //引入分页插件
        //传入当前页跟页面大小
        PageHelper.startPage(pageNumber,5);
        List<Employee> all = employeeService.getAll();
        //使用pageInfo包装查询的结果
        //封装了详细的分页信息,包括我们查询的数据 ,连续传入5页
        PageInfo page=new PageInfo(all,5);
        return page!=null?JsonMsg.success().addInfo("page",page):JsonMsg.fail().addInfo("emp_error_getEmps","查询员工信息时发生错误");
    }

    public EmployeeController() {
    }


    /**
    * @Description: 添加一个员工返回操作结果 并对前端传来的数据进行校验
    * @Param: [employee]
    * @return: com.hrms.utils.JsonMsg
    * @Author: doddd
    * @Date: 2019/11/20
     *
     * @Valuid后面需要紧跟校验的数据 若要拿取校验结果 需要在数据后面紧跟BindingResult 顺序不能乱
    */
    @ResponseBody
    @RequestMapping(value = "saveEmp",method = RequestMethod.POST)
    public JsonMsg saveEmp(@Valid Employee employee, BindingResult bindingResult){
        //保存错误信息
        Map map=new HashMap();
        if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                //fieldError.getField()拿到错误的字段  fieldError.getDefaultMessage()拿到错误的消息 传回前端
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return JsonMsg.fail().addInfo("emp_fail_saveEmp",map);
        }else {
//            保存时进行后端同名校验 防止用户修改页面进行注入
            if(checkName(employee.getEmpName()).getCode()==100){
                int result = employeeService.saveEmp(employee);
                return result==1?JsonMsg.success().addInfo("emp_success_saveEmp","员工新增成功"):JsonMsg.fail().addInfo("emp_fail_saveEmp","新增员工时发生错误");
            }
            else {
                map.put("repeat","用户名重复");
                return JsonMsg.fail().addInfo("emp_fail_saveEmp",map);
            }
        }
    }


    /**
    * @Description: 校验名字是否相同
    * @Param: [name]
    * @return: com.hrms.utils.JsonMsg
    * @Author: doddd
    * @Date: 2019/11/18
    */
    @ResponseBody
    @RequestMapping(value = "checkName",method = RequestMethod.GET)
    public JsonMsg checkName(@RequestParam("name") String name){
        boolean result=employeeService.checkName(name);
        return result==true?JsonMsg.success():JsonMsg.fail();
    }


    /**
     * @Description: 查询当前id的员工信息
     * @Param: [id]
     * @return: com.hrms.utils.JsonMsg
     * @Author: doddd
     * @Date: 2019/11/21
     */
    @RequestMapping(value = "getEmp",method = RequestMethod.GET)
    @ResponseBody
   public JsonMsg getEmp(@RequestParam("id")Integer id){
       Employee emp = employeeService.getEmp(id);
       return emp!=null?JsonMsg.success().addInfo("emp",emp):JsonMsg.fail().addInfo("emp_fail_getEmp","获取员工信息失败");
   }


    /**
     * @Description: 接受前端传来的新员工信息 对数据库信息进行更新
     * @Param: [employee]
     * @return: com.hrms.utils.JsonMsg
     * @Author: doddd
     * @Date: 2019/11/21
     *
     * 路径中的id值跟Employee字段对应 服务器会帮我们自动封装
     */
    @ResponseBody
    @RequestMapping(value = "updateEmp/{empId}",method = RequestMethod.PUT)
   public JsonMsg updateEmp(Employee employee){
        int result = employeeService.updateEmp(employee);
        return result==1?JsonMsg.success().addInfo("emp_success_updateEmp","员工信息更新成功"):JsonMsg.fail().addInfo("emp_fail_updateEmp","员工信息更新失败");
    }


    /**
     * @Description: 删除一个或多个员工  (1)或(1-2-3-4)
     * @Param: [empId]
     * @return: com.hrms.utils.JsonMsg
     * @Author: doddd
     * @Date: 2019/11/22
     */
    @RequestMapping(value = "deleteEmp",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonMsg deleteEmp(@RequestParam("empIds") String empIds){
        int result;
        if(empIds.contains("-")){
            List<Integer> ids=new ArrayList<>();
            String[] split = empIds.split("-");
            for (String s : split) {
                ids.add(Integer.parseInt(s));
            }
            result = employeeService.deleteBatch(ids);
            System.out.println(result);
        }else{
            Integer empId=Integer.parseInt(empIds);
            result = employeeService.deleteEmp(empId);
        }
        return result>0?JsonMsg.success().addInfo("emp_success_deleteEmp","员工删除成功"):JsonMsg.fail().addInfo("emp_fail_deleteEmp","员工删除异常");
    }
}
