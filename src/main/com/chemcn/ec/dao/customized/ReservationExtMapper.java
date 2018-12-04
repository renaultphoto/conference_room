package main.com.chemcn.ec.dao.customized;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.com.chemcn.ec.entity.Reservation;
import main.com.chemcn.ec.entity.ReservationCustom;
import main.com.chemcn.ec.vo.PagingVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.annotation.MapperScan;

public interface ReservationExtMapper {

	/**
	 * 查询所有的预定会议信息
	 * @param reservationCustom
	 * @return
	 */
	public List<ReservationCustom> findRecords(ReservationCustom reservationCustom);

	/**
	 * 分页查询所有的预定会议信息
	 * @param pagingVO,reservation
	 * @return
	 */
	public List<ReservationCustom> findRecordsByPage(@Param("pagingVO") PagingVO pagingVO, @Param("reservationCustom") ReservationCustom reservationCustom);

	/**
	 * 统计所有预定会议信息条数
	 * @return
	 */
	public Integer countRecords(HashMap<String,Object> map);

	/**
	 * 查询失效后的所有的预定会议信息
	 * @param reservationCustom
	 * @return
	 */
	public List<ReservationCustom> findRecordsWithInvalid(ReservationCustom reservationCustom);
	/**
	 * 分页查询失效后所有的预定会议信息
	 * @param pagingVO,reservation
	 * @return
	 */
	public List<ReservationCustom> findRecordsWithInvalidByPage(@Param("pagingVO") PagingVO pagingVO, @Param("reservationCustom") ReservationCustom reservationCustom);

	/**
	 * 统计失效后所有预定会议信息条数
	 * @return
	 */
	public Integer countRecordsWithInvalid(HashMap<String,Object> map);

	/**
	 * 查询会议中的所有的预定会议信息
	 * @param reservationCustom
	 * @return
	 */
	public List<ReservationCustom> findRecordsWithOnMeeting(ReservationCustom reservationCustom);

	/**
	 * 查询未开始的所有的预定会议信息
	 * @param reservationCustom
	 * @return
	 */
	public List<ReservationCustom> findRecordsWithNotStarted(ReservationCustom reservationCustom);
	/**
	 * 分页查询未开始所有的预定会议信息
	 * @param pagingVO,reservation
	 * @return
	 */
	public List<ReservationCustom> findRecordsWithNotStartedByPage(@Param("pagingVO") PagingVO pagingVO, @Param("reservationCustom") ReservationCustom reservationCustom);

	/**
	 * 统计未开始所有预定会议信息条数
	 * @return
	 */
	public Integer countRecordsWithNotStarted(HashMap<String,Object> map);

	/**
	 * 查询时间冲突的会议室
	 * @param reservationCustom
	 * @return
	 */
	public List<ReservationCustom> findConfilctRoom(ReservationCustom reservationCustom);

}

