package main.com.chemcn.ec.entity;

import java.util.HashMap;

/**
 * Created by renaultZhou on 2018/11/28.
 * Reservation的扩展类
 */
public class ReservationCustom  {
    private static final long serialVersionUID = 1L;

    /**ID*/
    private Integer id;

    /**会议室ID*/
    private Integer roomId;

    /**用户名_ID*/
    private Integer userId;

    /**手机号*/
    private String mobile;

    /**会议标题*/
    private String meettingTitle;

    /**参与人*/
    private String attendPerson;

    /**会议内容*/
    private String meettingContent;

    /**开始时间*/
    private java.util.Date begintime;

    /**结束时间*/
    private java.util.Date endtime;

    /**日期*/
    private java.util.Date reservationDate;

    /**状态，00已预约，01取消预约*/
    private String status;

    /***/
    private String extend1;

    /***/
    private String extend2;

    /***/
    private String extend3;

    //用户昵称
    private String nickName;
    //会议室名称
    private String roomName;

    /**ID*/
    public void setId(Integer id){
        this.id=id;
    }
    /**ID*/
    public Integer getId(){
        return this.id;
    }

    /**会议室ID*/
    public void setRoomId(Integer roomId){
        this.roomId=roomId;
    }
    /**会议室ID*/
    public Integer getRoomId(){
        return this.roomId;
    }

    /**用户名_ID*/
    public void setUserId(Integer userId){
        this.userId=userId;
    }
    /**用户名_ID*/
    public Integer getUserId(){
        return this.userId;
    }

    /**手机号*/
    public void setMobile(String mobile){
        this.mobile=mobile;
    }
    /**手机号*/
    public String getMobile(){
        return this.mobile;
    }

    /**会议标题*/
    public void setMeettingTitle(String meettingTitle){
        this.meettingTitle=meettingTitle;
    }
    /**会议标题*/
    public String getMeettingTitle(){
        return this.meettingTitle;
    }

    /**参与人*/
    public void setAttendPerson(String attendPerson){
        this.attendPerson=attendPerson;
    }
    /**参与人*/
    public String getAttendPerson(){
        return this.attendPerson;
    }

    /**会议内容*/
    public void setMeettingContent(String meettingContent){
        this.meettingContent=meettingContent;
    }
    /**会议内容*/
    public String getMeettingContent(){
        return this.meettingContent;
    }

    /**开始时间*/
    public void setBegintime(java.util.Date begintime){
        this.begintime=begintime;
    }
    /**开始时间*/
    public java.util.Date getBegintime(){
        return this.begintime;
    }

    /**结束时间*/
    public void setEndtime(java.util.Date endtime){
        this.endtime=endtime;
    }
    /**结束时间*/
    public java.util.Date getEndtime(){
        return this.endtime;
    }

    /**日期*/
    public void setReservationDate(java.util.Date reservationDate){
        this.reservationDate=reservationDate;
    }
    /**日期*/
    public java.util.Date getReservationDate(){
        return this.reservationDate;
    }

    /**状态，00已预约，01取消预约*/
    public void setStatus(String status){
        this.status=status;
    }
    /**状态，00已预约，01取消预约*/
    public String getStatus(){
        return this.status;
    }

    /***/
    public void setExtend1(String extend1){
        this.extend1=extend1;
    }
    /***/
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("roomId",this.roomId);
        map.put("userId",this.userId);
        map.put("roomName",this.roomName);
        map.put("nickName",this.nickName);
        map.put("mobile",this.mobile);
        map.put("meettingTitle",this.meettingTitle);
        map.put("attendPerson",this.attendPerson);
        map.put("meettingContent",this.meettingContent);
        map.put("begintime",this.begintime);
        map.put("endtime",this.endtime);
        map.put("reservationDate",this.reservationDate);
        map.put("status",this.status);
        map.put("extend1",this.extend1);
        map.put("extend2",this.extend2);
        map.put("extend3",this.extend3);
        return map;
    }
}
