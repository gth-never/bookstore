package com.bookstore.service.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.dto.BookDto;
import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import com.bookstore.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by never on 17-3-10.
 */
@Service("bookService")
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;
    @Autowired
    private CategoryDao categoryDao;

    public List<Book> getAllByPage(Map<String,Object> map) {
        return bookDao.queryAllByPage(map);
    }

    public int addBook(Book book) {
        return bookDao.insertBook(book);
    }

    public int deleteBookById(int bookId) {
        return bookDao.deleteBookById(bookId);
    }

    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    public Book getById(int bookId) {
        return bookDao.queryById(bookId);
    }
    public Book getByName(String bookName) {
        return bookDao.queryByName(bookName);
    }

    public List<Book> getBySomeName(String someName) {
        return bookDao.queryBySomeName(someName);
    }

    public List<Book> getByCategory(String categoryName) {
        return bookDao.queryByCategory(categoryName);
    }

    public List<Book> getByAuthor(String author) {
        return bookDao.queryByAuthor(author);
    }

    public List<Book> getByPriceArea(Float lowPrice, Float highPrice) {
        return bookDao.queryByPriceArea(lowPrice,highPrice);
    }
}
