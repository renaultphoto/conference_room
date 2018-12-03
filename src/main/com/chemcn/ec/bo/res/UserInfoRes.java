package main.com.chemcn.ec.bo.res;

import main.com.chemcn.ec.entity.User;
import main.com.chemcn.ec.pojo.ResultDo;

/**
 * @Author: zhoujl
 * @Date: 2018/12/3 10:07
 * @Description:
 */
public class UserInfoRes extends ResultDo {

    private static final long serialVersionUID = 1L;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
