package com.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImp implements CheckoutService{

    @Autowired
    private BookService bookService;

    @Transactional
    @Override
    //checkout有事务注解用的是required，所以在当前事务中允许余额为100，两本书要80，50余额不足
    //无法购买，因此在购买第二本书时checkout回滚
    public void checkoutBooks(int[] bookIds, int userId) {
        for(int bookId:bookIds){
            bookService.buyBook(bookId,userId);
        }
    }
}
