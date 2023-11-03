package com.coocaa.telecloudmanage.config;

import com.coocaa.telecloudmanage.filter.ApiFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 项目名称：tele-cloud-manage
 * 类 名 称：TeleWebMvcConfigurer
 * 类 描 述：TODO
 * 创建时间：2023/11/2 22:31
 * 创 建 人：zhanghonghao
 */
@Component
public class TeleWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    ApiFilter apiFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiFilter).addPathPatterns("/**");
    }

}
