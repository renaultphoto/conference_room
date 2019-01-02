package main.com.chemcn.ec.bo.res;

import lombok.Getter;
import lombok.Setter;
import main.com.chemcn.ec.entity.ReservationCustom;
import main.com.chemcn.ec.pojo.ResultDo;

import java.util.List;

/**
 * @Author: zhoujl
 * @Date: 2018/12/20 16:23
 * @Description: Pc端未开始和会议中的预定列表
 */
@Getter
@Setter
public class ReservationNotFinishRes extends ResultDo {

    private static final long serialVersionUID = 1L;

    private List<ReservationCustom> list;

    private int total;

}
