package com.example.SpringBootFirst.springStarterCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Cacheable(value = "book")
public class BookService {


    @Autowired
    private BookDao bookDao;

    public List<Books> showBooks(){
        return bookDao.findAll();
    }

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
