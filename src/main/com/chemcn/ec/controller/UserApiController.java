package main.com.chemcn.ec.controller;

import main.com.chemcn.ec.bo.res.UserInfoRes;
import main.com.chemcn.ec.entity.User;
import main.com.chemcn.ec.pojo.ResultDo;
import main.com.chemcn.ec.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhoujl
 * @Date: 2018/11/28 23:03
 * @Description:
 */
@Controller
@RequestMapping("/api/user")
public class UserApiController {
    private static Logger logger = Logger.getLogger(UserApiController.class);

    /**会议室服务*/
    @Autowired
    public UserService userService;

    /**
     * 查询会员信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/findUser", method = {RequestMethod.POST})
    @ResponseBody
    public UserInfoRes findUser(User user) {
        logger.info("查询会员信息");
        UserInfoRes res = new UserInfoRes();
        res = userService.findUser(user);
        return res;
    }

    /**
     * 完善会员信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/completeUser", method = {RequestMethod.POST})
    @ResponseBody
    public ResultDo completeUser(User user) {
        logger.info("完善会员信息");
        ResultDo res = new ResultDo();
        res = userService.completeUser(user);
        return res;
    }


}
