package com.cxm.springmvc.constant;

public class CommonException extends RuntimeException {
    private String code;
    private String msg;
    private String detailMsg;

    public CommonException(String code) {
        this.code = code;
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public CommonException(Throwable cause, String code) {
        super(cause);
        this.code = code;
        this.detailMsg = cause.getMessage();
    }

    public CommonException(String msg, String code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }
}
