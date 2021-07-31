package com.mkyong.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.mkyong.helloworld.service.DummyCacheService.*;

/**
 * @author rumman
 * @since 7/31/21
 */
@Service
@CacheConfig(cacheNames = CACHE_KEY)
public class DummyCacheService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldService.class);

    public static final String CACHE_KEY = "VALUE_STORE_CACHE";

    @Cacheable
    public Object getValueByKey(Integer key) {
        LOGGER.debug("getValueByKey:: Cached Value not used, looking up with key: {}", key);
        return new Object();
    }

    @CachePut
    public Object updateValueStore(Integer key) {
        return new Object();
    }

    @CacheEvict
    public void removeMap(Integer key) {
    }
}
