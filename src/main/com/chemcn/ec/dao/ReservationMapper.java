package main.com.chemcn.ec.dao;

import main.com.chemcn.ec.entity.ReservationCustom;
import main.com.chemcn.ec.vo.PagingVO;
import main.com.chemcn.ec.entity.Reservation;
import main.com.chemcn.ec.vo.ReservationVo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Admiral on 2018/1/19.
 */
public interface ReservationMapper {

    /**
     *新增会议室预定
     * @param parameters
     */
    public void addReservation(Reservation parameters);

    /**
     * 更新会议室预定信息
     * @param parameters
     */
    public void updateReservation(Reservation parameters);
    /**
     * 查询所有预定的列表
     * @return
     */
    public List<Reservation> findRecords(HashMap<String,Object> map);


}
