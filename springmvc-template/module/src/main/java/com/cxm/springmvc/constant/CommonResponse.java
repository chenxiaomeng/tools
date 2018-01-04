package com.cxm.springmvc.constant;

public class CommonResponse {

    private Integer code = CommonConstant.SUCCESS_CODE;

    private String msg;

    private Object data;

    public CommonResponse() {
    }

    public CommonResponse(Object data) {
        this.setData(data);
    }

    public CommonResponse(Object data, Integer code) {
        this.setCode(code);
        this.setData(data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
