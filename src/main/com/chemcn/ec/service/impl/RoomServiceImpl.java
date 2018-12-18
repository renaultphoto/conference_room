package main.com.chemcn.ec.service.impl;

import main.com.chemcn.ec.bo.res.RoomListRes;
import main.com.chemcn.ec.constants.ReservationConstants;
import main.com.chemcn.ec.dao.RoomMapper;
import main.com.chemcn.ec.dao.customized.ReservationExtMapper;
import main.com.chemcn.ec.entity.ReservationCustom;
import main.com.chemcn.ec.utils.BeanUtil;
import main.com.chemcn.ec.vo.PagingVO;
import main.com.chemcn.ec.entity.Room;
import main.com.chemcn.ec.service.RoomService;
import main.com.chemcn.ec.vo.RoomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admiral on 2018/1/19.
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private ReservationExtMapper reservationExtMapper;

 /*   @Override
    public Integer roomCount() {
        return roomMapper.roomCount();
    }*/

    @Override
    public List<Room> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<Room> list =new ArrayList<Room>();
                //roomMapper.findByPaging(pagingVO);
        return list;
    }

    @Override
    public void add(Room room) throws Exception {
       // roomMapper.add(room);
    }

/*    @Override
    public Room findById(Integer id) throws Exception {
        // return roomMapper.findById(id);
    }*/

    @Override
    public void updateById(Room room) throws Exception {
        // roomMapper.updateById(room);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        //  roomMapper.removeById(id);
    }

    @Override
    public List<Room> findByName(String name) throws Exception {
        List<Room> list =new ArrayList<Room>();
         return list;
                 //roomMapper.findByName(name);
    }

    @Override
    public RoomListRes findAllRoom(){
        RoomListRes res = new RoomListRes();
        Room room = new Room();
        List<Room> list =new ArrayList<Room>();
        List<RoomVo> voList =new ArrayList<RoomVo>();
        try {
            list = roomMapper.findRecords(room.toHashMap());
            for(Room roomEntity :list){
                RoomVo vo = new RoomVo();
                BeanUtil.copyProperties(roomEntity,vo);
                ReservationCustom reservation = new ReservationCustom();
                reservation.setRoomId(roomEntity.getId());
                List<ReservationCustom> reservationList = reservationExtMapper.findRecordsWithOnMeeting(reservation);
                if(reservationList.size()>0){
                    vo.setOnMeeting(ReservationConstants.RESERVATION_ONMEETING_);
                }
                voList.add(vo);
            }
            res.setList(voList);
        }catch (Exception e){
            res.setSuccess(false);
            res.setMessage("查找会议室失败");
            res.setCode(404);
        }
         return res;
    }

}
