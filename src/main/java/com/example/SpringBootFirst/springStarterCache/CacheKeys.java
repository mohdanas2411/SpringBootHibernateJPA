package com.example.SpringBootFirst.springStarterCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentMap;

@Service
public class CacheKeys {

    @Autowired
    CacheManager cacheManager;


    public Object getAllCacheMapEntries() {
        System.out.print("Cache Names : ");
        cacheManager.getCacheNames().stream().forEach(System.out::println);

        return cacheManager.getCache("book").getNativeCache();
    }

    public Books printDataFromCacheConcurrentMap(Integer op) {
        ConcurrentMap<String,Books> book = (ConcurrentMap<String, Books>) cacheManager.getCache("book").getNativeCache();
        System.out.println("getting key value from cache concurrent map  : "+book.get(op));

        return book.get(op);
    }
}
