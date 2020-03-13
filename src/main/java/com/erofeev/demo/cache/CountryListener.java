package com.erofeev.demo.cache;

import com.erofeev.demo.repo.model.Country;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class CountryListener implements CacheEventListener<String, Country> {

    @Override
    public void onEvent(CacheEvent<? extends String, ? extends Country> cacheEvent) {
        System.out.println("Country changed to: " + cacheEvent.getNewValue());
    }
}
