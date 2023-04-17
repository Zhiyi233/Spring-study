package com.tx.dao;

public interface BookDao {
    int getBookpriceByBookId(Integer bookId);
    void updateStock(Integer bookId);
    void updateUserBalance(Integer userId,Integer price);
}
