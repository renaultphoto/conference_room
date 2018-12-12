package main.com.chemcn.ec.entity;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by Admiral on 2018/1/18.
 */
public class User {
    private static final long serialVersionUID = 1L;

    /***/
    private Integer id;

    /**用户名*/
    private String account;

    /**昵称*/
    private String nickName;

    /**密码*/
    private String password;

    /**手机号*/
    private String mobile;

    /**邮箱*/
    private String mail;

    /***/
    private String openid;

    /**头像*/
    private String headimg;

    /**职位*/
    private String position;

    /**部门*/
    private String department;

    /**地址*/
    private String address;

    /**性别*/
    private String gender;

    /**session_key*/
    private String sessionKey;

    /**角色*/
    private Integer role;

    /**session_key*/
    private String extend1;

    /***/
    private String extend2;

    /***/
    private String extend3;

    /**内网IP*/
    private String internalIp;

    /**外网IP*/
    private String outerIp;

    /**创建时间*/
    private Date createTime;

    /***/
    public void setId(Integer id){
        this.id=id;
    }
    /***/
    public Integer getId(){
        return this.id;
    }

    /**用户名*/
    public void setAccount(String account){
        this.account=account;
    }
    /**用户名*/
    public String getAccount(){
        return this.account;
    }

    /**昵称*/
    public void setNickName(String nickName){
        this.nickName=nickName;
    }
    /**昵称*/
    public String getNickName(){
        return this.nickName;
    }

    /**密码*/
    public void setPassword(String password){
        this.password=password;
    }
    /**密码*/
    public String getPassword(){
        return this.password;
    }

    /**手机号*/
    public void setMobile(String mobile){
        this.mobile=mobile;
    }
    /**手机号*/
    public String getMobile(){
        return this.mobile;
    }

    /**邮箱*/
    public void setMail(String mail){
        this.mail=mail;
    }
    /**邮箱*/
    public String getMail(){
        return this.mail;
    }

    /***/
    public void setOpenid(String openid){
        this.openid=openid;
    }
    /***/
    public String getOpenid(){
        return this.openid;
    }

    /**头像*/
    public void setHeadimg(String headimg){
        this.headimg=headimg;
    }
    /**头像*/
    public String getHeadimg(){
        return this.headimg;
    }

    /**职位*/
    public void setPosition(String position){
        this.position=position;
    }
    /**职位*/
    public String getPosition(){
        return this.position;
    }

    /**部门*/
    public void setDepartment(String department){
        this.department=department;
    }
    /**部门*/
    public String getDepartment(){
        return this.department;
    }

    /**地址*/
    public void setAddress(String address){
        this.address=address;
    }
    /**地址*/
    public String getAddress(){
        return this.address;
    }

    /**性别*/
    public void setGender(String gender){
        this.gender=gender;
    }
    /**性别*/
    public String getGender(){
        return this.gender;
    }

    /**session_key*/
    public void setSessionKey(String sessionKey){
        this.sessionKey=sessionKey;
    }
    /**session_key*/
    public String getSessionKey(){
        return this.sessionKey;
    }

    /**角色*/
    public void setRole(Integer role){
        this.role=role;
    }
    /**角色*/
    public Integer getRole(){
        return this.role;
    }

    /**session_key*/
    public void setExtend1(String extend1){
        this.extend1=extend1;
    }
    /**session_key*/
    public String getExtend1(){
        return this.extend1;
    }

    /***/
    public void setExtend2(String extend2){
        this.extend2=extend2;
    }
    /***/
    public String getExtend2(){
        return this.extend2;
    }

    /***/
    public void setExtend3(String extend3){
        this.extend3=extend3;
    }
    /***/
    public String getExtend3(){
        return this.extend3;
    }

    public String getInternalIp() {
        return internalIp;
    }

    public void setInternalIp(String internalIp) {
        this.internalIp = internalIp;
    }

    public String getOuterIp() {
        return outerIp;
    }

    public void setOuterIp(String outerIp) {
        this.outerIp = outerIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("account",this.account);
        map.put("nickName",this.nickName);
        map.put("password",this.password);
        map.put("mobile",this.mobile);
        map.put("mail",this.mail);
        map.put("openid",this.openid);
        map.put("headimg",this.headimg);
        map.put("position",this.position);
        map.put("department",this.department);
        map.put("address",this.address);
        map.put("gender",this.gender);
        map.put("sessionKey",this.sessionKey);
        map.put("role",this.role);
        map.put("extend1",this.extend1);
        map.put("extend2",this.extend2);
        map.put("extend3",this.extend3);
        map.put("internalIp",this.extend1);
        map.put("outerIp",this.extend2);
        map.put("createTime",this.extend3);
        return map;
    }
}
