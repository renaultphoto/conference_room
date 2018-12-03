package main.com.chemcn.ec.bo.res;

import main.com.chemcn.ec.entity.Room;
import main.com.chemcn.ec.pojo.ResultDo;

import java.util.List;

/**
 * @Author: zhoujl
 * @Date: 2018/11/28 22:16
 * @Description:
 */
public class RoomListRes extends ResultDo {

    private static final long serialVersionUID = 1L;

    private List<Room> list;

    public List<Room> getList() {
        return list;
    }

    public void setList(List<Room> list) {
        this.list = list;
    }
}
