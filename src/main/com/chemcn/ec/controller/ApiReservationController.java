package main.com.chemcn.ec.controller;

import main.com.chemcn.ec.bo.res.ReservationListRes;
import main.com.chemcn.ec.bo.res.ReservationTodayListRes;
import main.com.chemcn.ec.entity.ReservationCustom;
import main.com.chemcn.ec.pojo.ResultDo;
import main.com.chemcn.ec.service.ReservationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhoujl
 * @Date: 2018/12/3 15:49
 * @Description: 预定相关接口
 */
@Controller
@RequestMapping("/api/reservation")
public class ApiReservationController {

    private static Logger logger = Logger.getLogger(ApiReservationController.class);
    /**预定服务*/
    @Autowired
    public ReservationService reservationService;

    /**
     * 预约会议室功能
     * @param reservationCustom
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/reserveRoom", method = RequestMethod.POST)
    @ResponseBody
    public ResultDo reserveRoom(ReservationCustom reservationCustom) throws Exception {
        ResultDo res = new ResultDo();
        res = reservationService.addReservation(reservationCustom);
        return res;
    }

    /**
     * 取消预约申请
     * @param id
     * @return
     */
    @RequestMapping(value ="/cancelApply", method = RequestMethod.POST)
    @ResponseBody
    public ResultDo cancelApplication(@RequestParam(value="id")Integer id){
        ResultDo res = new ResultDo();
        res = reservationService.cancelApplication(id);
        return res;
    }

    /**
     * 根据会议室、用户查询未开始会议信息
     * @param reservationCustom
     * @return
     */
    @RequestMapping(value ="/findNotStartReservationList", method = RequestMethod.POST)
    @ResponseBody
    public ReservationListRes findNotStartReservationList(ReservationCustom reservationCustom){
        ReservationListRes res = new ReservationListRes();
        res = reservationService.findNotStartReservationList(reservationCustom);
        return res;
    }

    /**
     * 根据会议室、用户查询已失效会议信息
     * @param reservationCustom
     * @return
     */
    @RequestMapping(value ="/findInvalidReservationList", method = RequestMethod.POST)
    @ResponseBody
    public ReservationListRes findInvalidReservationList(ReservationCustom reservationCustom){
        ReservationListRes res = new ReservationListRes();
        res = reservationService.findInvalidReservationList(reservationCustom);
        return res;
    }

    /**
     * 查询时间冲突的会议室
     * @param reservationCustom
     * @return
     */
    @RequestMapping(value ="/findConfilctRoom", method = RequestMethod.POST)
    @ResponseBody
    public ReservationListRes findConfilctRoom(ReservationCustom reservationCustom){
        ReservationListRes res = new ReservationListRes();
        res = reservationService.findConfilctRoom(reservationCustom);
        return res;
    }


    /**
     * 根据会议室ID和时间查询当天的会议室预定时间
     * @param reservationCustom
     * @return
     */
    @RequestMapping(value ="/findTodayReservation", method = RequestMethod.POST)
    @ResponseBody
    public ReservationTodayListRes findTodayReservation(ReservationCustom reservationCustom){
        ReservationTodayListRes res = new ReservationTodayListRes();
        res = reservationService.findTodayReservationListByRoom(reservationCustom);
        return res;
    }



}
