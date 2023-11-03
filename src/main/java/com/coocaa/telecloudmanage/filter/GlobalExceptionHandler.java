package com.coocaa.telecloudmanage.filter;

import com.coocaa.telecloudmanage.exception.BaseJSONException;
import com.coocaa.telecloudmanage.exception.ErrorCodes;
import com.coocaa.telecloudmanage.utils.ResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 项目名称：tele-cloud-manage
 * 类 名 称：ExceptionHandler
 * 类 描 述：TODO
 * 创建时间：2023/11/3 10:58
 * 创 建 人：zhanghonghao
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BaseJSONException.class)
    @ResponseBody
    public ResponseObject bizExceptionHandler(HttpServletRequest req, BaseJSONException e){
        log.error("发生业务异常！原因是：{}",e.getMessage());
        return ResponseObject.error(e.getError().getCode(), e.getMessage());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ResponseObject exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return ResponseObject.error(ErrorCodes.SYSTEM_ERROR);
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResponseObject exceptionHandler(HttpServletRequest req, Exception e){
        log.error("未知异常！原因是:",e);
        return ResponseObject.error(ErrorCodes.SERVICE_UNAVAILABLE.getCode(),e.getMessage());
    }

}
