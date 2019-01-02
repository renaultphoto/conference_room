package main.com.chemcn.ec.service.impl;

import main.com.chemcn.ec.bo.req.ReservationNotFinishReq;
import main.com.chemcn.ec.bo.res.ReservationListRes;
import main.com.chemcn.ec.bo.res.ReservationNotFinishRes;
import main.com.chemcn.ec.bo.res.ReservationTodayListRes;
import main.com.chemcn.ec.dao.ReservationMapper;
import main.com.chemcn.ec.dao.customized.ReservationExtMapper;
import main.com.chemcn.ec.entity.Reservation;
import main.com.chemcn.ec.entity.ReservationCustom;
import main.com.chemcn.ec.pojo.ResultDo;
import main.com.chemcn.ec.utils.BeanUtil;
import main.com.chemcn.ec.utils.StringToDateConverter;
import main.com.chemcn.ec.vo.ReservationVo;
import main.com.chemcn.ec.constants.ReservationConstants;
import main.com.chemcn.ec.vo.PagingVO;
import main.com.chemcn.ec.service.ReservationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhoujl on 2018/12/03.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private ReservationExtMapper rservationExtMapper;

    @Override
    public ResultDo addReservation(ReservationCustom reservationCustom){
        ResultDo res = new ResultDo();
        Reservation reservation = new Reservation();
        try {
            if(reservationCustom == null){
                res.setSuccess(false);
                res.setMessage("预定信息为空!");
                res.setCode(404);
                return res;
            }
            if(!reservationCustom.getBegintime().before(reservationCustom.getEndtime())){
                res.setSuccess(false);
                res.setMessage("开始时间不小于结束时间");
                res.setCode(404);
                return res;
            }
            if(!reservationCustom.getBegintime().before(reservationCustom.getEndtime())){
                res.setSuccess(false);
                res.setMessage("开始时间不小于结束时间");
                res.setCode(404);
                return res;
            }
            BeanUtil.copyProperties(reservationCustom,reservation);
            reservation.setCreateTime(new Date());
            reservation.setStatus(ReservationConstants.RESERVATION_ORDER);
            reservationMapper.addReservation(reservation);
            res.setMessage("预定成功!");
        }catch (Exception e){
            res.setSuccess(false);
            res.setMessage("预定失败!");
            res.setCode(404);
        }
        return res;
    }
    @Override
    public ResultDo cancelApplication(Integer id){
        ResultDo res = new ResultDo();
        Reservation reservation = new Reservation();
        if (id != null){
            reservation.setId(id);
            reservation.setStatus(ReservationConstants.RESERVATION_CANCLE);
        }else{
            res.setMessage("取消预约失败-预约ID不能为空");
            res.setSuccess(false);
            res.setCode(404);
            return res;
        }
        try {
            reservationMapper.updateReservation(reservation);
            res.setMessage("取消预约成功");
        }catch (Exception e){
            res.setMessage("取消预约失败");
            res.setSuccess(false);
            res.setCode(404);
        }
        return res;
    }

    /**
     * 查询未开始的预定信息
     * @param reservationCustom
     * @return
     */

    public ReservationListRes findNotStartReservationList(ReservationCustom reservationCustom){
        ReservationListRes res = new ReservationListRes();
        if(reservationCustom == null){
            res.setMessage("查询信息为空");
            res.setCode(404);
            res.setSuccess(false);
            return  res;
        }
        try{
            reservationCustom.setStatus(ReservationConstants.RESERVATION_ORDER);
            List<ReservationCustom> list =  rservationExtMapper.findRecordsWithNotStarted(reservationCustom);
            res.setMessage("查询未开始的预定信息成功");
            res.setList(list);
        }catch (Exception e){
            res.setMessage("查询信息失败");
            res.setCode(404);
            res.setSuccess(false);
        }
        return res;

    }

    /**
     * 查询已失效的预定信息
     *
     * @param reservationCustom
     * @return
     */
    @Override
    public ReservationListRes findInvalidReservationList(ReservationCustom reservationCustom) {
        ReservationListRes res = new ReservationListRes();
        if(reservationCustom == null){
            res.setMessage("查询已失效的预定信息为空");
            res.setCode(404);
            res.setSuccess(false);
            return  res;
        }
        try{
            reservationCustom.setStatus(ReservationConstants.RESERVATION_ORDER);
            List<ReservationCustom> list =  rservationExtMapper.findRecordsWithInvalid(reservationCustom);
            res.setMessage("查询已失效的预定信息成功");
            res.setList(list);
        }catch (Exception e){
            res.setMessage("查询已失效的预定信息失败");
            res.setCode(404);
            res.setSuccess(false);
        }
        return res;
    }

    /**
     * 查询某一个会议室的预定信息列表
     *
     * @param reservationCustom
     * @return
     */
    @Override
    public ReservationListRes findReservationListByRoom(ReservationCustom reservationCustom) {
        ReservationListRes res = new ReservationListRes();
        if(reservationCustom == null || reservationCustom.getRoomId() ==null){
            res.setMessage("查询信息为空");
            res.setCode(404);
            res.setSuccess(false);
            return  res;
        }
        try{
            reservationCustom.setStatus(ReservationConstants.RESERVATION_ORDER);
            List<ReservationCustom> list =  rservationExtMapper.findRecords(reservationCustom);
            res.setMessage("查询预定信息成功");
            res.setList(list);
        }catch (Exception e){
            res.setMessage("查询信息失败");
            res.setCode(404);
            res.setSuccess(false);
        }
        return res;
    }

    /**
     * 查询有冲突的会议室
     *
     * @param reservationCustom
     * @return
     */
    @Override
    public ReservationListRes findConfilctRoom(ReservationCustom reservationCustom) {
        ReservationListRes res = new ReservationListRes();
        if(reservationCustom == null || reservationCustom.getRoomId() ==null){
            res.setMessage("查询信息为空");
            res.setCode(404);
            res.setSuccess(false);
            return  res;
        }
        try{
            reservationCustom.setStatus(ReservationConstants.RESERVATION_ORDER);
           Date d = new Date();
            List<ReservationCustom> list =  rservationExtMapper.findConfilctRoom(reservationCustom);
            res.setMessage("查询有冲突的会议室成功");
            res.setList(list);
        }catch (Exception e){
            res.setMessage("查询有冲突的会议室失败");
            res.setCode(404);
            res.setSuccess(false);
        }
        return res;
    }

    /**
     * 查询当天的会议室预定情况
     *
     * @param reservationCustom
     * @return
     */
    @Override
    public ReservationTodayListRes findTodayReservationListByRoom(ReservationCustom reservationCustom) {
        ReservationTodayListRes res = new ReservationTodayListRes();
        if(reservationCustom == null || reservationCustom.getRoomId() ==null){
            res.setMessage("查询信息为空");
            res.setCode(404);
            res.setSuccess(false);
            return  res;
        }
        try{
            List<String> periods = new ArrayList<String>();
            reservationCustom.setStatus(ReservationConstants.RESERVATION_ORDER);
            List<ReservationCustom> list =  rservationExtMapper.findRecords(reservationCustom);
            for(ReservationCustom r : list){
                String[] arr = r.getPeriod().split(",");
                for(String a :arr){
                    periods.add(a);
                }
            }
            res.setMessage("查询预定信息成功");
            res.setList(list);
            res.setPeriods(periods);
        }catch (Exception e){
            res.setMessage("查询信息失败");
            res.setCode(404);
            res.setSuccess(false);
        }
        return res;
    }

    /**
     * PC端查询所有未开始和会议中的列表
     *
     * @param reservationNotFinishReq
     * @return
     */
    @Override
    public ReservationNotFinishRes findReservationNotFinish(ReservationNotFinishReq reservationNotFinishReq) {
        ReservationNotFinishRes res = new ReservationNotFinishRes();
        Integer total = 0;
        try {
            reservationNotFinishReq.setStatus(ReservationConstants.RESERVATION_ORDER);
            List<ReservationCustom> list =  rservationExtMapper.findRecordsWithNotFinishByPage(reservationNotFinishReq.toHashMap());
            total = rservationExtMapper.countRecordsWithNotFinish(reservationNotFinishReq.toHashMap());
            res.setList(list);
            res.setTotal(total);
            res.setMessage("查询信息成功");
            res.setCode(200);
            res.setSuccess(true);
        }catch (Exception e){
            res.setMessage("查询信息失败");
            res.setCode(404);
            res.setSuccess(false);
        }
        return res;
    }

}
