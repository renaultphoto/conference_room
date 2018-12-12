package main.com.chemcn.ec.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
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

    /**发起人*/
    private String initiator;

    /**会议类型*/
    private String meetingType;

    /**时间段*/
    private String period;

    //用户昵称
    private String nickName;

    //会议室名称
    private String roomName;

    //会议室设备
    private String equipment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMeettingTitle() {
        return meettingTitle;
    }

    public void setMeettingTitle(String meettingTitle) {
        this.meettingTitle = meettingTitle;
    }

    public String getAttendPerson() {
        return attendPerson;
    }

    public void setAttendPerson(String attendPerson) {
        this.attendPerson = attendPerson;
    }

    public String getMeettingContent() {
        return meettingContent;
    }

    public void setMeettingContent(String meettingContent) {
        this.meettingContent = meettingContent;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
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
        map.put("roomName",this.roomName);
        map.put("nickName",this.nickName);
        map.put("equipment",this.equipment);
        return map;
    }
}
