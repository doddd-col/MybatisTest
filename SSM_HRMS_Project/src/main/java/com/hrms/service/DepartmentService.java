package com.hrms.service;

import com.hrms.bean.Department;
import com.hrms.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author doddd
 * @date 2019/11/19-10:25
 **/
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> getDepts(){
        //没有条件直接返回查到的数据
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }
}
