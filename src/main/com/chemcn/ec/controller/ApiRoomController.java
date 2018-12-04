package main.com.chemcn.ec.controller;

import main.com.chemcn.ec.bo.res.RoomListRes;
import main.com.chemcn.ec.service.RoomService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhoujl
 * @Date: 2018/12/3 15:48
 * @Description: 会议室相关接口
 */
@Controller
@RequestMapping("/api/room")
public class ApiRoomController {

    private static Logger logger = Logger.getLogger(ApiRoomController.class);

    /**会议室服务*/
    @Autowired
    public RoomService roomService;

    /**
     * 获取会议室列表
     * @return
     */
    @RequestMapping(value = "/getRoomList", method = {RequestMethod.GET})
    @ResponseBody
    public RoomListRes getRoomList() {
        logger.info("获取会议室列表");
        RoomListRes res = new RoomListRes();
        res = roomService.findAllRoom();
        return res;
    }
}
