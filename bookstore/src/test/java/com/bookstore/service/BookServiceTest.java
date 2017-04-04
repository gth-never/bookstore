package com.bookstore.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * Created by never on 17-3-11.
 */
/***
 * 配置spring和junit整合,junit启动时加载spring ioc容器
 * spring-test junit
 * 告诉junit spring的配置文件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Test
    public void getById() throws Exception {
        System.out.println(bookService.getById(1));
    }

}