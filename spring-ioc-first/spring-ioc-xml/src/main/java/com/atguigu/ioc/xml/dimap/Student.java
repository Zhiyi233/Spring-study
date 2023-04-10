package com.atguigu.ioc.xml.dimap;

import java.util.List;
import java.util.Map;

public class Student {
    private Map<String, Teacher> teacherMap;
    private List<Course> courseList;

    private String sid;
    private String sname;

    public void run(){
        System.out.println("student num :"+sid+"student's name:"+sname);

        System.out.println(teacherMap);
        System.out.println(courseList);
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
