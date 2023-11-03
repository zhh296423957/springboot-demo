package com.coocaa.telecloudmanage.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：tele-cloud-manage
 * 类 名 称：ErrorCodes
 * 类 描 述：TODO
 * 创建时间：2023/11/3 10:46
 * 创 建 人：zhanghonghao
 */
public enum ErrorCodes {

    SYSTEM_ERROR(10001,"服务器开小差了，请稍后重试"),
    SERVICE_UNAVAILABLE(10002,"服务器开小差了，请稍后重试：%s"),
    PARAMETER_REQUIRED(10003,"缺少参数"),
    PARAMETER_REQUIRED_WHAT(10003,"缺少参数: %s"),
    PARAMETER_ILLEGAL(10004,"请求参数错误"),
    PARAMETER_ILLEGAL1(10004,"请求参数错误:%s");

    Integer code;
    private final String msg;
    ErrorCodes(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg(){
        return this.msg;
    }

    @Override
    public String toString(){
        return String.format("{\"code\":%s,\"msg\":\"%s\"}",code,msg);
    }
    public static String toString(String code,String msg){
        return String.format("{\"code\":%s,\"msg\":\"%s\"}",code,msg);
    }

    public static ErrorCodes fromString(String code){
        return KEYS_MAP.get(Integer.valueOf(code));
    }

    private static final Map<Integer, ErrorCodes> KEYS_MAP =new HashMap<>();
    static{
        for(ErrorCodes e: ErrorCodes.values()){
            KEYS_MAP.put(e.code, e);
        }
    }

}
