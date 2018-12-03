package main.com.chemcn.ec.dao;

import main.com.chemcn.ec.vo.PagingVO;
import main.com.chemcn.ec.entity.Room;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Admiral on 2018/1/19.
 */
public interface RoomMapper {
    /**
     * 统计会议室
     * @param map
     * @return
     */
    public Integer roomCount(HashMap<String,Object> map);


    /**
     * 分页查询会议室
     * @param pagingVO
     * @param room
     * @return
     */
    public List<Room> findRecordsByPage( @Param("pagingVO") PagingVO pagingVO, @Param("room") Room room);

    /**
     * 查询会议室列表
     * @param map
     * @return
     */
    public List<Room> findRecords(HashMap<String,Object> map);


    /**
     * 新增会议室
     * @param room
     */
    public void insertRoom(Room room) ;

    /**
     * 更新会议室信息
     * @param room
     */
    public void updateRoom(Room room);
}
