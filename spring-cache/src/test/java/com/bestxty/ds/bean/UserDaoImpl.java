package com.bestxty.ds.bean;

import com.google.code.ssm.api.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xty on 2016/8/31.
 * for project: DistributedSystemTest.
 */
@Repository
public class UserDaoImpl implements IUserDao {

    private static final String NAMESPACE = "ns";
    private Map<String, User> users = new HashMap<>();

    @Override
    public void saveUser(User user) {
        users.put(user.getUserId(), user);
    }

    /**
     * 当执行getById查询方法时，系统首先会从缓存中获取userId对应的实体
     * 如果实体还没有被缓存，则执行查询方法并将查询结果放入缓存中
     */
    @Override
    @ReadThroughSingleCache(namespace = NAMESPACE, expiration = 3600)
    public User getById(@ParameterValueKeyProvider String userId) {
        System.out.println(userId);
        return users.get(userId);
    }

    /**
     * 当执行updateUser方法时，系统会更新缓存中userId对应的实体
     * 将实体内容更新成@*DataUpdateContent标签所描述的实体
     */
    @UpdateSingleCache(namespace = NAMESPACE, expiration = 3600)
    @Override
    public void updateUser(@ParameterValueKeyProvider @ParameterDataUpdateContent User user) {
        users.put(user.getUserId(), user);
    }

    /**
     * 当执行deleteUser方法时，系统会删除缓存中userId对应的实体
     */
    @InvalidateSingleCache(namespace = NAMESPACE)
    @Override
    public void deleteUser(@ParameterValueKeyProvider String userId) {
        users.remove(userId);
    }
}
