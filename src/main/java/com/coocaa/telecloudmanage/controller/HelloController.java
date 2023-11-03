package com.coocaa.telecloudmanage.controller;

import com.coocaa.telecloudmanage.utils.ResponseObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称：tele-cloud-manage
 * 类 名 称：HelloController
 * 类 描 述：TODO
 * 创建时间：2023/11/2 18:34
 * 创 建 人：zhanghonghao
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/world")
    public ResponseObject helloWorld(){
        return ResponseObject.success("hello world.");
    }
}
