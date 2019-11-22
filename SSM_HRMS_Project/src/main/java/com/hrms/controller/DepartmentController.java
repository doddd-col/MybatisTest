package com.hrms.controller;


import com.hrms.bean.Department;
import com.hrms.service.DepartmentService;
import com.hrms.utils.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author doddd
 * @date 2019/11/19-10:26
 **/

@Controller
@RequestMapping(value = "DepartmentController",method = RequestMethod.GET)
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @ResponseBody
    @RequestMapping("getDepts")
    public JsonMsg getDepts(){
        List<Department> depts = departmentService.getDepts();
        return depts!=null?JsonMsg.success().addInfo("depts",depts):JsonMsg.fail().addInfo("dept_error_getDept","查询部门信息时发生错误");
    }

}
