package com.atguigu.ioc.xml.ditest;

import java.util.List;

public class Department {
    //员工list
    private List<Employee> employeeList;

    private String dname;

    public void info(){
        System.out.println("部门名称："+dname);
        for(Employee emp:employeeList){
            System.out.println(emp.getEname());
        }
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
