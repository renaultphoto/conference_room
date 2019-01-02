package main.com.chemcn.ec.bo.req;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * @Author: zhoujl
 * @Date: 2018/12/20 15:29
 * @Description: 会议中和会议未开始的请求参数
 */
@Getter
@Setter
public class ReservationNotFinishReq {

    private static final long serialVersionUID = 1L;

    /**会议室ID*/
    private Integer roomId;

    /**用户名_ID*/
    private Integer userId;

    /**会议室名称*/
    private String roomName;

    /**手机号*/
    private String mobile;

    /**会议标题*/
    private String meettingTitle;

    /**参与人*/
    private String attendPerson;

    /**会议内容*/
    private String meettingContent;

    /**状态，00已预约，01取消预约*/
    private String status;

    /**发起人*/
    private String initiator;

    /**创建人*/
    private String nickName;

    /**去往页数*/
    private int toPageNo;

    /**每页10条记录*/
    private int pageSize=10;


    public HashMap<String, Object> toHashMap() {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("roomId",this.roomId);
        map.put("userId",this.userId);
        map.put("mobile",this.mobile);
        map.put("meettingTitle",this.meettingTitle);
        map.put("attendPerson",this.attendPerson);
        map.put("meettingContent",this.meettingContent);
        map.put("status",this.status);
        map.put("initiator",this.initiator);
        map.put("roomName",this.roomName);
        map.put("nickName",this.nickName);
        map.put("toPageNo",this.toPageNo);
        map.put("pageSize",this.pageSize);
        return map;
    }

}
