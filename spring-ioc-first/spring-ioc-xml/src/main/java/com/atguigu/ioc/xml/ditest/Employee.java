package com.atguigu.ioc.xml.ditest;

import java.util.Arrays;

public class Employee {
    private String ename;
    private Integer age;

    //一个员工属于某个部门，dep作为属性
    private Department dept;

    //hobby
    private String[] hobbies;

    public void work(){
        System.out.println(ename+" is working...."+age);
        dept.info();
        System.out.println(Arrays.toString(hobbies));
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
