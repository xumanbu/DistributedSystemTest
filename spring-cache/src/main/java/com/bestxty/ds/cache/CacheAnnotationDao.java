package com.bestxty.ds.cache;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author xty
 *         Created by xty on 2016/9/12.
 */
@Component
public class CacheAnnotationDao {

    @CachePut(value = "defaultCache", key = "#id")
    public long getUserById(long id) throws Exception {
        System.out.println("getUserById--没有缓存命中");
        return id;
    }

    @Cacheable(value = "defaultCache")
    public String getList(String author) throws Exception {
        System.out.println("getList--没有缓存命中");
        return author;
    }

}
