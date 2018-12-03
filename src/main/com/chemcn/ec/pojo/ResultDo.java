package main.com.chemcn.ec.pojo;

import main.com.chemcn.ec.vo.PagingVO;

import java.io.Serializable;

/**
 * @Author: zhoujl
 * @Date: 2018/11/28 21:08
 * @Description: 返回类
 */
public class ResultDo implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean success = true;
    private int code = 200;
    private String message;
    private PagingVO pagingInfo;

    public ResultDo() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PagingVO getPagingInfo() {
        return pagingInfo;
    }

    public void setPagingInfo(PagingVO pagingInfo) {
        this.pagingInfo = pagingInfo;
    }
    public String toString() {
        return "ResultDo [success=" + this.success + ", code=" + this.code + ", message=" + this.message + "]";
    }
}
