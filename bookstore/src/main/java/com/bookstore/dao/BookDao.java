package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * Created by never on 17-3-8.
 */
public interface BookDao {
    List<Book> queryAllByPage(Map<String,Object> map);
    Book queryById(int bookId);
    int insertBook(Book book);
    Book queryByName(String bookName);
    List<Book> queryBySomeName(String someName);
    List<Book> queryByCategory(String categoryName);
    List<Book> queryByAuthor(String author);
    //两个参数需要指定名称
    List<Book> queryByPriceArea(@Param("lowPrice") Float lowPrice,
                                @Param("highPrice") Float highPrice);
    int deleteBookById(int bookId);
    int updateBook(Book book);
    int count();
}
