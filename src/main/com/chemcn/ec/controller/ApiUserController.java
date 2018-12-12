package main.com.chemcn.ec.controller;

import main.com.chemcn.ec.bo.res.UserInfoRes;
import main.com.chemcn.ec.constants.UserConstants;
import main.com.chemcn.ec.entity.User;
import main.com.chemcn.ec.pojo.ResultDo;
import main.com.chemcn.ec.service.UserService;
import main.com.chemcn.ec.utils.HttpRequest;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhoujl
 * @Date: 2018/11/28 23:03
 * @Description:
 */
@Controller
@RequestMapping("/api/user")
public class ApiUserController {
    private static Logger logger = Logger.getLogger(ApiUserController.class);

    /**用户服务*/
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

    /**
     * 微信登录
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Map decodeUserInfo(String code) {

        Map map = new HashMap();
        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }

        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = "";
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "";
        //授权（必填）
        String grant_type = "";




        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        Map userInfo = new HashMap();
        try {
            //校验openId 是否存在
            User userOpen = new User();
            userOpen.setOpenid(openid);
            UserInfoRes res = new UserInfoRes();
            res = userService.findUser(userOpen);
            if(res.getCode() == UserConstants.USER_EXIST){
                userInfo.put("openid", openid);
                userInfo.put("id", res.getUser().getId());
                map.put("userInfo", userInfo);
                if(null == res.getUser().getNickName() || res.getUser().getNickName().isEmpty()){
                    map.put("isSubmit", false);
                }else{
                    map.put("isSubmit", true);
                }
                map.put("code", 200);
                map.put("msg", "登录成功");
                return map;
            }
            //新增用户
            User user = new User();
            user.setOpenid(openid);
            user.setSessionKey(session_key);
            user.setPassword("111111");
            userService.addNewUser(user);
            map.put("userInfo", userInfo);
            userInfo.put("openid", openid);
            userInfo.put("id", user.getId());
            map.put("isSubmit", false);
            map.put("code", 200);
            map.put("msg", "登录成功");
            return map;
        } catch (Exception e) {
            map.put("status", 201);
            map.put("msg", "登录失败");
            return map;
        }
    }


}
