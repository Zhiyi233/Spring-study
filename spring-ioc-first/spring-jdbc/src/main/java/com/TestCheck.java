package com;

import com.tx.controller.BookController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCheck {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        BookController bookController = context.getBean(BookController.class);
        int[] bookIds = {1,2};
        bookController.checkout(bookIds,1);
    }
}
