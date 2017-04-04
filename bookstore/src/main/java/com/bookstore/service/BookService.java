package com.bookstore.service;

import com.bookstore.dto.BookDto;
import com.bookstore.entity.Book;
import com.bookstore.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by never on 17-3-10.
 */
public interface BookService {
    List<Book> getAllByPage(Map<String,Object> map);
    int addBook(Book book);
    int deleteBookById(int bookId);
    int updateBook(Book book);
    Book getById(int bookId);
    Book getByName(String bookName);
    List<Book> getBySomeName(String someName);
    List<Book> getByCategory(String categoryName);
    List<Book> getByAuthor(String author);
    List<Book> getByPriceArea(Float lowPrice,Float highPrice);
}
