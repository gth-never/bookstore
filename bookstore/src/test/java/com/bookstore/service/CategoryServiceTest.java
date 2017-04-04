package com.bookstore.service;

import com.bookstore.dao.CategoryDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by never on 17-3-19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CategoryServiceTest {
    @Autowired
    private CategoryDao categoryDao;
    @Test
    public void getById() throws Exception {
        System.out.println(categoryDao.queryById(1));
    }

    @Test
    public void getAll() throws Exception {
        System.out.println(categoryDao.queryAll());
    }

}