package com.coocaa.telecloudmanage.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：tele-cloud-manage
 * 类 名 称：ApiFilter
 * 类 描 述：TODO
 * 创建时间：2023/11/2 22:26
 * 创 建 人：zhanghonghao
 */
@Component
@Slf4j
public class ApiFilter implements HandlerInterceptor {

    private NamedThreadLocal<Long> threadLocal = new NamedThreadLocal("StopWatch_StartTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //1.开始时间
        long startTime = System.currentTimeMillis();
        //2.绑定变量(只有当前请求线程可见)
        threadLocal.set(startTime);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        //3.结束时间(请求处理完成)
        long endTime = System.currentTimeMillis();
        //4.取出开始时间
        long startTime = threadLocal.get();
        //5.计算耗时
        long consumeTime = endTime - startTime;
        //此处认为处理时间超过500毫秒的请求为慢请求
        //此处可以做一些复杂的告警通知,如与 IM即时通信应用、邮件系统、短信系统对接
        log.info("【NORMAL】API:{}, consumeTime:{} millis", request.getRequestURI(), consumeTime);

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
    }

}
