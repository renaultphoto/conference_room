package main.com.chemcn.ec.bo.res;

import main.com.chemcn.ec.entity.ReservationCustom;
import main.com.chemcn.ec.pojo.ResultDo;

import java.util.List;

/**
 * @Author: zhoujl
 * @Date: 2018/12/3 16:01
 * @Description: 预定列表返回
 */
public class ReservationTodayListRes extends ResultDo {

    private static final long serialVersionUID = 1L;

    private List<ReservationCustom> list;

    private List<String>  periods;

    public List<ReservationCustom> getList() {
        return list;
    }

    public void setList(List<ReservationCustom> list) {
        this.list = list;
    }

    public List<String> getPeriods() {
        return periods;
    }

    public void setPeriods(List<String> periods) {
        this.periods = periods;
    }
}
