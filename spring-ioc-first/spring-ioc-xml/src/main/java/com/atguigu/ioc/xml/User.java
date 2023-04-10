package com.atguigu.ioc.xml;

/*
基于xml管理ioc
 */
public class User {
    private String name;
    private Integer age;

    public void run(){
        System.out.println(name+" run......");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
