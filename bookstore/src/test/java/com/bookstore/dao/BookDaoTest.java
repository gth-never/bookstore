package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.util.Page;
import org.apache.commons.collections.FastHashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by never on 17-3-10.
 */

/***
 * 配置spring和junit整合,junit启动时加载spring ioc容器
 * spring-test junit
 * 告诉junit spring的配置文件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;
    @Test
    public void queryById() throws Exception {
        System.out.println(bookDao.queryById(3));
    }
    @Test
    public void insertBook() throws Exception{
        Book book=new Book(".net从入门到放弃","番茄","新都人民出版社", 99.80f,"计算机","2006年5月1日",10);
        book.setCategoryId(1);
        int line=bookDao.insertBook(book);
        System.out.println(line+" : bookId: "+book.getBookId());
        System.out.println(book);
    }
    @Test
    public void queryByName() throws Exception {
        System.out.println(bookDao.queryByName("大话设计模式"));
    }
    @Test
    public void queryBySomeName() throws Exception {
        List<Book> books=bookDao.queryBySomeName("入门到");
        for (Book book:books) {
            System.out.println(book);
        }
    }
    @Test
    public void queryByCategory() throws Exception {
        List<Book> books=bookDao.queryByCategory("计算机");
        for (Book book:books) {
            System.out.println(book);
            System.out.println("-----------------------------------------------");
        }
    }
    @Test
    public void queryByAuthor() throws Exception {
        List<Book> books=bookDao.queryByAuthor("耳根");
        for (Book book:books) {
            System.out.println(book);
            System.out.println("-----------------------------------------------");
        }
    }
    @Test
    public void queryByPriceArea() throws Exception {
        List<Book> books=bookDao.queryByPriceArea(20f,null);
        for (Book book:books) {
            System.out.println(book);
            System.out.println("-----------------------------------------------");
        }
    }
    @Test
    public void deleteBookById() throws Exception{
        bookDao.deleteBookById(8);
    }
    @Test
    public void updateBook() throws Exception{
        Book book=bookDao.queryById(2);
        System.out.println(book);
        book.setPrice(3.0f);
        System.out.println(book);
        bookDao.updateBook(book);
    }
    @Test
    public void queryAll() throws Exception {
        Page page = new Page();
        //System.out.println(bookDao.count());
        //page.setTotalNumber(bookDao.count());
        Map<String,Object> map=new FastHashMap();
        map.put("page",page);
        List<Book> books = bookDao.queryAllByPage(map);
        for (Book book : books) {
            System.out.println(book);
            System.out.println("-----------------------------------------------");
        }
    }
}