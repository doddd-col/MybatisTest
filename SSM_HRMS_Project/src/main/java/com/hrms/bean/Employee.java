package com.hrms.bean;

import javax.validation.constraints.Pattern;

public class Employee {

    private Integer empId;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", deptId=" + deptId +
                ", department=" + department +
                '}';
    }

    //    利用和前端同样的正则表达式进行校验
    @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})",message = "用户名可以是6-16位英文数字混合或2-5位中文")
    private String empName;

    @Pattern(regexp = "^([a-zA-Z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",message = "邮箱格式不正确")
    private String email;

    private String gender;

    private Integer deptId;

    private Department department;
    public Employee() {
    }
    public Employee(Integer empId, String empName, String email, String gender, Integer deptId, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.deptId = deptId;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}