package main.com.chemcn.ec.vo;

/**
 * @Author: zhoujl
 * @Date: 2018/10/31 16:09
 * @Description: 日程显示
 */
public class CalendarViewVO{

    private Integer id;// 主键
    private String title;// 标题;
    private String start;// 开始时间
    private String end;// 结束时间
    private String url;// 结束时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
