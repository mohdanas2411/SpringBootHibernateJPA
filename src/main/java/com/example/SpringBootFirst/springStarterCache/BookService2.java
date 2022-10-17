package com.example.SpringBootFirst.springStarterCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentMap;

@Service
public class BookService2 {
    @Autowired
    private BookDao bookDao;

    @Autowired
    CacheManager cacheManager;

    @Cacheable(value = "book")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Books thirdMethod() {
        //here id = 904 is not even present in database but we get output cause there is no key in this method and default key is empty and thats value is returned
        Books books = bookDao.findById(904).orElseThrow();
        System.out.println(
                "ThirdMethod " + books.getBookId()
        );
        return books;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Cacheable(value = "book", key = "{#isbn,#includeUsed}")
    public Books sixMethod() {
        //for unique key generation    key = "{#isbn,#includeUsed}"
        Books books = bookDao.findById(903).orElseThrow();
        System.out.println(
                "sixMethod " + books.getBookId()
        );
        return books;
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Cacheable(value = "book")
    public Books fifthMethod(int id) {
        Books books = bookDao.findById(id).orElseThrow();
        System.out.println(
                "fifthMethod " + books.getBookId()
        );
        return books;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Cacheable(value = "book")
    public Books seventhMethod(int id, String name) {
        Books books = bookDao.findById(id).orElseThrow();
        System.out.println(
                "seventhMethod " + books.getBookId() + "  name : " + name
        );
        return books;
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Books forthMethod(int id) {
        ConcurrentMap<String, Books> book = (ConcurrentMap<String, Books>) cacheManager.getCache("book").getNativeCache();
       //here accessing cache concurrent map directly
        if (book.get(id) != null) {
            return book.get(id);
        } else {
            Books books = bookDao.findById(id).orElseThrow();
            System.out.println(
                    "forthMethod " + books.getBookId()
            );
            return books;
        }
    }

}
