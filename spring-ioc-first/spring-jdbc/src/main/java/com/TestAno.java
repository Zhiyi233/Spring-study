package com;

import com.tx.config.SpringConfig;
import com.tx.controller.BookController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAno {
    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = context.getBean(BookController.class);
        int[] bookIds = {1,2};
        bookController.checkout(bookIds,1);
    }
}
