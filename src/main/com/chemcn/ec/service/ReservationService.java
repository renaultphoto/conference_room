package main.com.chemcn.ec.service;

import main.com.chemcn.ec.bo.res.ReservationListRes;
import main.com.chemcn.ec.bo.res.ReservationTodayListRes;
import main.com.chemcn.ec.entity.ReservationCustom;
import main.com.chemcn.ec.pojo.ResultDo;

/**
 * Created by zhoujl on 2018/12/03.
 */
public interface ReservationService {
    /**
     * 添加会议室预约
     * @param reservationCustom
     */
    public ResultDo addReservation(ReservationCustom reservationCustom);

    /**
     * 根据id取消会议室申请
     * @param id
     * @throws Exception
     */
    public ResultDo cancelApplication(Integer id);

    /**
     * 查询未开始的预定信息
     * @param reservationCustom
     * @return
     */

    public ReservationListRes findNotStartReservationList(ReservationCustom reservationCustom);

    /**
     * 查询已失效的预定信息
     * @param reservationCustom
     * @return
     */

    public ReservationListRes findInvalidReservationList(ReservationCustom reservationCustom);

    /**
     * 查询某一个会议室的预定信息列表
     * @param reservationCustom
     * @return
     */
    public ReservationListRes findReservationListByRoom(ReservationCustom reservationCustom);

    /**
     * 查询有冲突的会议室
     * @param reservationCustom
     * @return
     */
    public ReservationListRes findConfilctRoom(ReservationCustom reservationCustom);

    /**
     * 查询当天的会议室预定情况
     * @param reservationCustom
     * @return
     */
    public ReservationTodayListRes findTodayReservationListByRoom(ReservationCustom reservationCustom);

}
