package com.bestxty.ds.bean;

/**
 * Created by xty on 2016/8/31.
 * for project: DistributedSystemTest.
 */
public interface IUserDao {

    void saveUser(User user);

    User getById(String userId);

    void updateUser(User user);


    void deleteUser(String userId);

}
