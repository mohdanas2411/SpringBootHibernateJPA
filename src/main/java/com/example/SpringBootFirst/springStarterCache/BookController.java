package com.example.SpringBootFirst.springStarterCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @Autowired
    CacheKeys cacheKeys;
    @Autowired
    private BookService2 bookService2;

    @GetMapping("api/book/show")
    public List<Books> showBooks(){
        return bookService.showBooks();
    }

    @GetMapping("api/book/first")
    public Books firstMethod(){
        return bookService.firstMethod();
    }

    @GetMapping("api/book/second")
    public Books secondMethod(){
        return bookService.secondMethod();
    }

    @GetMapping("api/book/third")
    public Books thirdMethod(){
        return bookService2.thirdMethod();
    }


 @GetMapping("api/book/six")
    public Books sixMethod(){
        return bookService2.sixMethod();
    }

    @GetMapping("api/book/forth/{id}")
    public Books forthMethod(@PathVariable("id") int id){
        return bookService2.forthMethod(id);
    }

    @GetMapping("api/book/fifth/{id}")
    public Books fifthMethod(@PathVariable("id") int id){
        return bookService2.fifthMethod(id);
    }

    @GetMapping("api/book/seventh/{id}")
    public Books seventhMethod(@PathVariable("id") int id){
        return bookService2.seventhMethod(id,"anas");
    }

    @GetMapping("api/book/getAllCache")
    public Object getcache(){
        return cacheKeys.getAllCacheMapEntries();
    }

    @GetMapping("api/book/print/{op}")
    public Books printData(@PathVariable("op")Integer op){
        return cacheKeys.printDataFromCacheConcurrentMap(op);
    }

}
