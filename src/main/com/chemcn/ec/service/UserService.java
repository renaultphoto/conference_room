package main.com.chemcn.ec.service;

import main.com.chemcn.ec.bo.res.UserInfoRes;
import main.com.chemcn.ec.entity.User;
import main.com.chemcn.ec.pojo.ResultDo;

/**
 * Created by Admiral on 2018/1/19.
 */
public interface UserService {

    /**
     * 根据用户查询条件查找用户
     * @param user
     * @return
     */
    public UserInfoRes findUser(User user);

    /**
     * 添加新用户
     * @param user
     * @throws Exception
     */
    public ResultDo addNewUser(User user);

    /**
     * 完善会员信息
     * @param user
     * @return
     */
    public ResultDo completeUser(User user);

}
