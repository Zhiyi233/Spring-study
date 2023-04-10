package com.atguigu.ioc.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 相当于把一下
 * <context:component-scan base-package="com.atguigu.ioc"></context:component-scan>
 * 用下面两个替换了
 * @Configuration
 * @ComponentScan("com.atguigu.ioc")
 */
@Configuration
@ComponentScan("com.atguigu.ioc")
public class springConf {
}
