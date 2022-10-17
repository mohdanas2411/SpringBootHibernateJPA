package com.example.SpringBootFirst.springStarterCache;

import com.example.SpringBootFirst.employeeJPA.Employee;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class CacheEventLogger implements CacheEventListener<Object, Object> {

    private static Log log = LogFactory.getLog(CacheEventLogger.class);

    @Override
    public void onEvent(
            CacheEvent<? extends Object, ? extends Object> cacheEvent) {
    }
}