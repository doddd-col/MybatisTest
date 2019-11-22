package com.hrms.service;

import com.hrms.bean.Employee;
import com.hrms.bean.EmployeeExample;
import com.hrms.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author doddd
 * @date 2019/11/19-10:25
 **/
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    public int saveEmp(Employee employee) {
        return employeeMapper.insert(employee);
    }

    //检查名字是否可用
    public boolean checkName(String name) {
        //从employeeExample中获取criteria
        EmployeeExample employeeExample=new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        //再利用criteria调取相关条件方法 实现条件查询 当前条件是查询同名  返回符合条件人数
        criteria.andEmpNameEqualTo(name);
        long count = employeeMapper.countByExample(employeeExample);
        return count==0?true:false;
    }


    public Employee getEmp(Integer id) {
        //查询等于主键的员工信息
        return employeeMapper.selectByPrimaryKey(id);
    }

    public int updateEmp(Employee employee) {
//        根据主键有选择的更新
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public int deleteEmp(Integer empId) {
        return employeeMapper.deleteByPrimaryKey(empId);
    }

    public int deleteBatch(List<Integer> empIds) {
        EmployeeExample employeeExample=new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        //设置条件员工id在一个list里面  sql变成DELETE from xxx where empId in (list集合)
        criteria.andEmpIdIn(empIds);
        return employeeMapper.deleteByExample(employeeExample);
    }
}