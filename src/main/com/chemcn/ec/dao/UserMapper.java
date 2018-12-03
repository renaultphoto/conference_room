package main.com.chemcn.ec.dao;

import main.com.chemcn.ec.entity.User;

import java.util.HashMap;

/**
 * Created by Admiral on 2018/1/19.
 */
public interface UserMapper {
    /**
     * 查询用户信息
     * @param map
     * @return
     */
    public User findRecords(HashMap<String,Object> map);

    /**
     * 更新用户信息
     * @param parameters
     */
    public void updateUser(User parameters);

    /**
     * 新增用户
     * @param parameters
     */
    public void insertRecord(User parameters);
}
