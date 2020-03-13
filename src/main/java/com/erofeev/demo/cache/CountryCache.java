package com.erofeev.demo.cache;

import com.erofeev.demo.repo.model.Country;
import lombok.Data;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheEventListenerConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.event.EventType;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

//@Data
//@Component
public class CountryCache {

    private CountryListener countryListener;
    private CacheManager cacheManager;
    private Cache<String, Country> countriesCache;

    public CountryCache(CountryListener countryListener) {
        cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();

        CacheEventListenerConfigurationBuilder cacheEventListenerConfiguration = CacheEventListenerConfigurationBuilder
                .newEventListenerConfiguration(countryListener, EventType.CREATED, EventType.UPDATED)
                .unordered().asynchronous();

        countriesCache =
                cacheManager.createCache("countries", CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(String.class, Country.class, ResourcePoolsBuilder.heap(10))
                        .add(cacheEventListenerConfiguration)
                        .withExpiry(Expirations.timeToLiveExpiration(Duration.of(200,
                                TimeUnit.SECONDS))).build());
        this.countryListener = countryListener;
    }

    public Cache<String, Country> getCountriesCacheFromCacheManager() {
        return cacheManager.getCache("countries", String.class, Country.class);
    }
}