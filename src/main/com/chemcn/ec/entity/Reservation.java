package main.com.chemcn.ec.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by renaultZhou on 2018/11/28.
 * 预定对象
 */
public class Reservation {
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

    /**发起人*/
    private String initiator;

    /**会议类型*/
    private String meetingType;

    /**时间段*/
    private String period;

    /**创建日期*/
    private java.util.Date createTime;

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

    /**发起人*/
    public void setInitiator(String initiator){
        this.initiator=initiator;
    }
    /**发起人*/
    public String getInitiator(){
        return this.initiator;
    }

    /**会议类型*/
    public void setMeetingType(String meetingType){
        this.meetingType=meetingType;
    }
    /**会议类型*/
    public String getMeetingType(){
        return this.meetingType;
    }

    /**时间段*/
    public void setPeriod(String period){
        this.period=period;
    }
    /**时间段*/
    public String getPeriod(){
        return this.period;
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
        map.put("roomId",this.roomId);
        map.put("userId",this.userId);
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
        map.put("initiator",this.initiator);
        map.put("meetingType",this.meetingType);
        map.put("period",this.period);
        map.put("createTime",this.createTime);
        return map;
    }
}
