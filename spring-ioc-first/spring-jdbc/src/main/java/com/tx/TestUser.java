package com.tx;

import com.tx.controller.BookController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        BookController bookController = context.getBean(BookController.class);
       // bookController.buyBook(1,1);

    }
}
