package com.tx.controller;

import com.tx.service.BookService;
import com.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
//    @Autowired
//    private BookService bookService;
//
//    public void buyBook(Integer bookId,Integer userId){
//        bookService.buyBook(bookId,userId);
//    }

    //加入了CheckoutService
    @Autowired
    private CheckoutService checkoutService;

    public void checkout(int[] bookIds,int userId){
        checkoutService.checkoutBooks(bookIds,userId);
    }
}
