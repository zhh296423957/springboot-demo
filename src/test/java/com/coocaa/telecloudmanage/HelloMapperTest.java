package com.coocaa.telecloudmanage;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.coocaa.telecloudmanage.entity.Id;
import com.coocaa.telecloudmanage.mapper.HelloMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 项目名称：tele-cloud-manage
 * 类 名 称：HelloMapperTest
 * 类 描 述：TODO
 * 创建时间：2023/11/3 13:54
 * 创 建 人：zhanghonghao
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloMapperTest {

    @Autowired
    HelloMapper helloMapper;

    @Test
    public void testSelect(){
        List<Id> list = helloMapper.selectList(null);
        System.out.println(list);
    }

}
