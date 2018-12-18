package main.com.chemcn.ec.vo;

import main.com.chemcn.ec.entity.Room;

/**
 * @Author: zhoujl
 * @Date: 2018/12/17 18:56
 * @Description: 会议室页面展示
 */
public class RoomVo extends Room {
    private String onMeeting;

    public String getOnMeeting() {
        return onMeeting;
    }

    public void setOnMeeting(String onMeeting) {
        this.onMeeting = onMeeting;
    }
}
