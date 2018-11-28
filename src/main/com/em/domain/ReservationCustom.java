package main.com.em.domain;

/**
 * Created by renaultZhou on 2018/11/28.
 * Reservation的扩展类
 */
public class ReservationCustom extends Reservation {
    //会议室名称
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
