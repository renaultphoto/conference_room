package main.com.chemcn.ec.bo.res;

import main.com.chemcn.ec.entity.Room;
import main.com.chemcn.ec.pojo.ResultDo;
import main.com.chemcn.ec.vo.RoomVo;

import java.util.List;

/**
 * @Author: zhoujl
 * @Date: 2018/11/28 22:16
 * @Description:
 */
public class RoomListRes extends ResultDo {

    private static final long serialVersionUID = 1L;

    private List<RoomVo> list;

    public List<RoomVo> getList() {
        return list;
    }

    public void setList(List<RoomVo> list) {
        this.list = list;
    }
}
