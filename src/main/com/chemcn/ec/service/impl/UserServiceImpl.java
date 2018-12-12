package main.com.chemcn.ec.service.impl;

import main.com.chemcn.ec.bo.res.UserInfoRes;
import main.com.chemcn.ec.constants.UserConstants;
import main.com.chemcn.ec.dao.UserMapper;
import main.com.chemcn.ec.entity.User;
import main.com.chemcn.ec.pojo.ResultDo;
import main.com.chemcn.ec.service.UserService;
import main.com.chemcn.ec.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by zhoujl on 2018/12/03.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户查询条件查找用户
     * @param user
     * @return
     */
    @Override
    public UserInfoRes findUser(User user) {
        UserInfoRes res = new UserInfoRes();
        User userTemp = null;
        try{
            if(user != null){
                userTemp = userMapper.findRecords(user.toHashMap());
                if(userTemp == null){
                    res.setMessage("暂无此用户");
                    res.setCode(UserConstants.USER_NOTHISUSER);
                    res.setSuccess(true);
                }else{
                    res.setMessage("该用户已存在");
                    res.setCode(UserConstants.USER_EXIST);
                    res.setSuccess(true);
                    res.setUser(userTemp);
                }
            }else{
                res.setMessage("查询条件为空");
                res.setCode(404);
                res.setSuccess(false);
            }
        }catch (Exception e){
            res.setMessage("查询用户失败");
            res.setCode(404);
            res.setSuccess(false);
        }
        return res;
    }

    /**
     * 添加新用户
     * @param user
     * @throws Exception
     */
    @Override
    public ResultDo addNewUser(User user) {
        ResultDo res = new ResultDo();
        try{
            String account = "U"+System.currentTimeMillis();
            user.setAccount(account);
            user.setRole(UserConstants.USER_CUSTOMER);
            user.setInternalIp(IpUtil.getIntranetIp());
            user.setOuterIp(IpUtil.getOuterNetIp());
            user.setCreateTime(new Date());
            userMapper.insertRecord(user);
            res.setMessage("用户新增成功");
        }catch (Exception e){
            res.setCode(404);
            res.setSuccess(false);
            res.setMessage("用户信息新增失败");
        }
        return res;
    }

    /**
     * 完善会员信息
     *
     * @param user
     * @return
     */
    @Override
    public ResultDo completeUser(User user) {
        ResultDo res = new ResultDo();
        try{
            userMapper.updateUser(user);
            res.setMessage("用户信息更新成功");
        }catch (Exception e){
            res.setCode(404);
            res.setSuccess(false);
            res.setMessage("用户信息更新失败");
        }
        return res;
    }

/*    @Override
    public User findUserById(String account){
        User user = new User();
        if(!account.isEmpty() && account != null){
            user.setAccount(account);
            userMapper.findRecords(user.toHashMap());
        }else{

        }
        return user;
    }

    @Override
    public void addNewUser(User user) throws Exception {
        //userMapper.addNewUser(user);
    }*/
}
