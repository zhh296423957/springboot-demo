package com.coocaa.telecloudmanage.utils;

import com.coocaa.telecloudmanage.exception.ErrorCodes;

/**
 * 项目名称：tele-cloud-manage
 * 类 名 称：ResponseObject
 * 类 描 述：TODO
 * 创建时间：2023/11/3 10:52
 * 创 建 人：zhanghonghao
 */
public class ResponseObject<T> {

    private boolean success;
    private Integer code;
    private String message;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 构建成功结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseObject<T> success(T data){
        ResponseObject<T> result = new ResponseObject<>();
        result.setData(data);
        result.setCode(0);
        result.setSuccess(true);
        return result;
    }

    public static <T> ResponseObject<T> error(Integer errorCode, String error){
        ResponseObject<T> result = new ResponseObject<>();
        result.setSuccess(false);
        result.setCode(errorCode);
        result.setMessage(error);
        return  result;
    }

    public static <T> ResponseObject<T> error(Integer errorCode, String error, T data){
        ResponseObject<T> result = new ResponseObject<>();
        result.setSuccess(false);
        result.setCode(errorCode);
        result.setMessage(error);
        result.setData(data);
        return  result;
    }

    public static <T> ResponseObject<T> error(ErrorCodes error){
        ResponseObject<T> result = new ResponseObject<>();
        result.setSuccess(false);
        result.setCode(error.getCode());
        result.setMessage(error.getMsg());
        return  result;
    }

    /**
     * 设置成功消息，并不返回任何值
     * @param <T>
     * @return
     */
    public static <T> ResponseObject<T> success(){
        ResponseObject<T> result = new ResponseObject<>();
        result.setSuccess(true);
        result.setCode(0);
        result.setMessage("success");
        return result;
    }
}
