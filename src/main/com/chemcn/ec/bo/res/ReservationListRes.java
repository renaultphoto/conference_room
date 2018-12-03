package main.com.chemcn.ec.bo.res;

import main.com.chemcn.ec.entity.ReservationCustom;
import main.com.chemcn.ec.pojo.ResultDo;

import java.util.List;

/**
 * @Author: zhoujl
 * @Date: 2018/12/3 16:01
 * @Description: 预定列表返回
 */
public class ReservationListRes extends ResultDo {

    private static final long serialVersionUID = 1L;

    private List<ReservationCustom> list;

    public List<ReservationCustom> getList() {
        return list;
    }

    public void setList(List<ReservationCustom> list) {
        this.list = list;
    }
}
