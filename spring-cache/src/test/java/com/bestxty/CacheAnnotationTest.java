package com.bestxty;

import com.bestxty.ds.cache.CacheAnnotationDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xty
 *         Created by xty on 2016/9/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-cache-test.xml"})
public class CacheAnnotationTest extends AbstractJUnit4SpringContextTests {


    private CacheAnnotationDao annotationDao;

    @Test
    public void testMemCache() throws Exception {
        annotationDao = applicationContext.getBean(CacheAnnotationDao.class);

        annotationDao.getUserById(123);

        annotationDao.getUserById(123);

        annotationDao.getList("123343");

        annotationDao.getList("123343");
        annotationDao.getList("123343");
    }
}
