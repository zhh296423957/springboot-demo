package com.coocaa.telecloudmanage.exception;

/**
 * 项目名称：tele-cloud-manage
 * 类 名 称：BaseJSONException
 * 类 描 述：TODO
 * 创建时间：2023/11/3 10:49
 * 创 建 人：zhanghonghao
 */
public class BaseJSONException extends RuntimeException{

    private ErrorCodes error;
    private String[] replaces;

    public BaseJSONException(){
        super();
    }

    public BaseJSONException(ErrorCodes error, String... replaces) {
        this.error = error;
        this.replaces = replaces;
    }

    public BaseJSONException(ErrorCodes error) {
        this.error = error;
    }

    public String[] getReplaces() {
        return this.replaces;
    }

    public ErrorCodes getError() {
        return this.error;
    }



    @Override
    public String getMessage() {
        String msg = error.getMsg();
        if(replaces != null && replaces.length > 0){
            msg = String.format(msg, replaces);
        }
        return msg;
    }

}
