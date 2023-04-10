package com.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TestCar {
    /**
     * 获取class对象的多种方式
     */
    @Test
    public void test01() throws Exception {
        //.Class
        Class clazz1 = Car.class;

        //getClass()
        Class clazz2 = new Car().getClass();

        //Class.forName("全路径")
        Class clazz3 = Class.forName("com.reflect.Car");
        Car car3 = (Car) clazz3.getConstructor().newInstance();
        System.out.println(car3);
    }

    @Test
    public void test02() throws Exception {
        //.Class
        Class clazz1 = Car.class;
        //getConstructors()是针对的public构造
//        Constructor[] constructors = clazz1.getConstructors();

        //针对private构造需要用到getDeclaredConstructors()
        Constructor[] constructors = clazz1.getDeclaredConstructors();
        for (Constructor c: constructors) {
            System.out.println("Constructor name: " +c.getName()+" parameter nums: " +c.getParameterCount());
        }

        //指定私有构造器
        Constructor c2 = clazz1.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true); //allow us to change
        Car car = (Car) c2.newInstance("沃尔沃", 123, "棕色0");
        System.out.println(car);

        //指定public构造器
        Constructor c3 = clazz1.getConstructor(String.class, int.class);
        Car car2 =(Car) c3.newInstance("阳光", 9292);
        System.out.println(car2);

        Field[] fileds = clazz1.getDeclaredFields();
        Car car3 = (Car) clazz1.getDeclaredConstructor().newInstance();

        for (Field f:fileds) {
            if (f.getName().equals("name")) {
                f.setAccessible(true);
                f.set(car3, "五菱");
//              System.out.println(f.getName());
            }
            System.out.println(car3);
        }
    }

    @Test
    public void test3() throws Exception {
        Class clazz1 = Car.class;

        Field[] fileds = clazz1.getDeclaredFields();
        Car car = (Car) clazz1.getDeclaredConstructor().newInstance();

        for (Field f:fileds) {
//            if (f.getName().equals("name")) {
//                f.setAccessible(true);
//                f.set(car, "五菱");
////              System.out.println(f.getName());
//            }
            System.out.println(f.getGenericType()+" "+f.getName());

          //  System.out.println(car);
        }
    }

}
