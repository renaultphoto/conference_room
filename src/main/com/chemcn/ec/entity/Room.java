package main.com.chemcn.ec.entity;

import java.util.HashMap;

/**
 * Created by Admiral on 2018/1/18.
 */
public class Room {

    private static final long serialVersionUID = 1L;

    /***/
    private Integer id;

    /***/
    private String roomName;

    /***/
    private String description;

    /***/
    private String roomImg;

    /**设备*/
    private String equipment;

    /***/
    private String extends1;

    /***/
    private String extends2;

    /***/
    private String extends3;

    /***/
    public void setId(Integer id){
        this.id=id;
    }
    /***/
    public Integer getId(){
        return this.id;
    }

    /***/
    public void setRoomName(String roomName){
        this.roomName=roomName;
    }
    /***/
    public String getRoomName(){
        return this.roomName;
    }

    /***/
    public void setDescription(String description){
        this.description=description;
    }
    /***/
    public String getDescription(){
        return this.description;
    }

    /***/
    public void setRoomImg(String roomImg){
        this.roomImg=roomImg;
    }
    /***/
    public String getRoomImg(){
        return this.roomImg;
    }

    /**设备*/
    public void setEquipment(String equipment){
        this.equipment=equipment;
    }
    /**设备*/
    public String getEquipment(){
        return this.equipment;
    }

    /***/
    public void setExtends1(String extends1){
        this.extends1=extends1;
    }
    /***/
    public String getExtends1(){
        return this.extends1;
    }

    /***/
    public void setExtends2(String extends2){
        this.extends2=extends2;
    }
    /***/
    public String getExtends2(){
        return this.extends2;
    }

    /***/
    public void setExtends3(String extends3){
        this.extends3=extends3;
    }
    /***/
    public String getExtends3(){
        return this.extends3;
    }


    public HashMap<String, Object> toHashMap() {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("id",this.id);
        map.put("roomName",this.roomName);
        map.put("description",this.description);
        map.put("roomImg",this.roomImg);
        map.put("equipment",this.equipment);
        map.put("extends1",this.extends1);
        map.put("extends2",this.extends2);
        map.put("extends3",this.extends3);
        return map;
    }
}
