package main.com.chemcn.ec.controller;

import main.com.chemcn.ec.bo.res.ReservationListRes;
import main.com.chemcn.ec.utils.StringToDateConverter;
import main.com.chemcn.ec.entity.*;
import main.com.chemcn.ec.service.ReservationService;
import main.com.chemcn.ec.vo.CalendarViewVO;
import main.com.chemcn.ec.vo.PagingVO;
import main.com.chemcn.ec.vo.ReservationVo;
import main.com.chemcn.ec.service.RoomService;
import main.com.chemcn.ec.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: zhoujl
 * @Date: 2018/10/31 10:47
 * @Description: 公共的功能
 */
@Controller
@RequestMapping("/public")
public class PublicController {
    @Resource(name = "roomServiceImpl")
    private RoomService roomService;

    @Resource(name = "reservationServiceImpl")
    private ReservationService reservationService;

    @Resource(name = "userServiceImpl")
    private UserService userService;

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<会议室预约管理>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

  /*  // 会议室信息显示
    @RequestMapping("/showRoom")
    public String showRoom(Model model, Integer page) throws Exception {

        List<Room> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(roomService.roomCount());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = roomService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = roomService.findByPaging(page);
        }

        model.addAttribute("roomList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "/public/showRoom";
    }

    //查询接下来的15天内所有已被预约的会议室记录
    @RequestMapping("/showRecord")
    public String findAllReservation(Model model, Integer page) throws Exception {
        List<ReservationVo> list = null;

        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(reservationService.reserveCount());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = reservationService.findAllByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = reservationService.findAllByPaging(page);
        }

        model.addAttribute("recordList", list);
        model.addAttribute("pagingVo", pagingVO);

        return "/public/showRecord";
    }

    *//**
     * 跳转会议预定记录
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/toRecord")
    public String toRecord(Model model) throws Exception {

        return "/public/showRecordTable";
    }
    /**
     *展示会议预定信息
     * @return
     */
    @RequestMapping(value = "showRecordTable", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> showRecordTable()  {
        StringToDateConverter covert = new StringToDateConverter();
        Map<String, Object>  map = new HashMap<String, Object>();
        ReservationListRes res = new ReservationListRes();
        ReservationCustom reservationCustom = new ReservationCustom();
        reservationCustom.setRoomId(7);
        res = reservationService.findReservationListByRoom(reservationCustom);
        List<CalendarViewVO> listTemp = new ArrayList<CalendarViewVO>();
        Date date=null;
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(ReservationCustom vo :res.getList()){
            CalendarViewVO vVo = new CalendarViewVO();
            vVo.setId(vo.getId());
            vVo.setStart(dateFormat.format(vo.getBegintime()));
            vVo.setEnd(dateFormat.format(vo.getEndtime()));
            vVo.setUrl("#");
            vVo.setTitle(vo.getMeettingTitle());
            listTemp.add(vVo);
        }
        map.put("list",listTemp);
        return map;
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<用户信息管理>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*//*
    //添加新用户
    @RequestMapping(value = "/userRegister", method = {RequestMethod.GET})
    public String userRegister(Model model) throws Exception {
        return "/public/userRegister";
    }

    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public String userRegister(User user) throws Exception{
        if(user.getAccount()!=null && user.getAccount()!="" && user.getPassword()!=null && user.getPassword()!=""){
            userService.addNewUser(user);
        }
        return "redirect:/login";
    }
*/
}
