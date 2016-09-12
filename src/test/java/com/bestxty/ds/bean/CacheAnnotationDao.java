package com.bestxty.ds.bean;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author xty
 *         Created by xty on 2016/9/12.
 */
public class CacheAnnotationDao {

    @CachePut(value = "defaultCache",key="#id")
    public long getUserById(long id) throws Exception{
        System.out.println("没有缓存命中");
        return id;
    }
    @Cacheable(value = "defaultCache")
    public String getList(String author) throws Exception {
        System.out.println("没有缓存命中");
        return author;
    }

}
