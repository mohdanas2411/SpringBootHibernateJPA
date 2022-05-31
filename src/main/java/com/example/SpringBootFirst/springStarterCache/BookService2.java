package com.example.SpringBootFirst.springStarterCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class BookService2 {
    @Autowired
    private BookDao bookDao;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Books firstMethod(){
        Books books = bookDao.findById(101).orElseThrow();
        System.out.println(
                "firstMethod "+ books.getBookId()
        );
        return books;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @CachePut(value = "book")
    public Books secondMethod(){
        Books books = bookDao.findById(101).orElseThrow();
        System.out.println(
                "SecondMethod "+ books.getBookId()
        );
        return books;
    }

}
