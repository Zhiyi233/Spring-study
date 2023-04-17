package com.tx.service;

import com.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

//@Transactional(readOnly = true)
//@Transactional(timeout = 3) //Transaction timed out: deadline was Sat Apr 15 13:24:12 CST 2023
//@Transactional(noRollbackFor = ArithmeticException.class)
//@Transactional(propagation = Propagation.REQUIRED)
@Transactional(propagation = Propagation.REQUIRES_NEW)
//不管当前线程是否有已经开启的事务，都要开启新的事务，同样的场景，每次购买书都在在buyBook()的事务中执行
//因此第一本图书购买成功，事务结束。第二本图书购买失败，只在第二次buybook中回滚
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //TODO 模拟超时效果
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //根据图书id查询价格
        int price = bookDao.getBookpriceByBookId(bookId);

        //更新图书表的库存量
        bookDao.updateStock(bookId);

        //更新用户表用户余额 -图书价格
        bookDao.updateUserBalance(userId,price);

//        System.out.println(1/0);
    }
}
