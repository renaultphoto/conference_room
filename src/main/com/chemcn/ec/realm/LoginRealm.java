package main.com.chemcn.ec.realm;

import main.com.chemcn.ec.entity.User;
import main.com.chemcn.ec.service.RoleService;
import main.com.chemcn.ec.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Carson on 2017/11/30.
 */

@Component
public class LoginRealm extends AuthorizingRealm{

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Resource(name = "roleServiceImpl")
    private RoleService roleService;


    /**
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
     *     当调用权限验证时，就会调用此方法
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String account = (String) getAvailablePrincipal(principalCollection);

        String role = null;

        try {
            User user = new User();
                    //userService.findUserById(account);
            Integer i=user.getRole();
            //获取角色对象
            role=roleService.findNameById(i);
            //role = roleService.findRoleById(user.getRole());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //通过用户名从数据库获取权限/角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> set = new HashSet<String>();
        if (role != null) {
            set.add(role);
            info.setRoles(set);
        }

        return info;
    }

    /**
     * 在这个方法中，进行身份验证
     *         login时调用
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名
        String account = (String) token.getPrincipal();
        //密码
        String password = new String((char[])token.getCredentials());

        User user = null;
        try {
            //user = userService.findUserById(account);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            //没有该用户名
            throw new UnknownAccountException("没有该用户名");
        } else if (!password.equals(user.getPassword())) {
            //密码错误
            throw new IncorrectCredentialsException("密码错误");
        }

        //身份验证通过,返回一个身份信息
        AuthenticationInfo loginInfo = new SimpleAuthenticationInfo(account,password,getName());

        return loginInfo;
    }
}
