package com.bookstore.web;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.entity.User;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;
import com.bookstore.service.UserService;
import com.bookstore.util.Page;
import org.apache.commons.collections.FastHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by never on 17-3-12.
 */
@Controller
@RequestMapping("/bookstore")
//http://localhost:8080/bookstore/
public class BookController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    private static Page page=new Page();
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello()
    {
        return "hello world mvc";
    }
    @RequestMapping(value = "/{bookId}/id/detail",method = RequestMethod.GET,
            produces = "text/json;charset=UTF-8")//添加produces = "text/json;charset=UTF-8"解决乱码问题
    //@ResponseBody
    public String getBookById(@PathVariable Integer bookId,Model model)
    {
        Book book=bookService.getById(bookId);
        //logger.info(book.toString());
        //System.out.println(book.toString());
        model.addAttribute("book",book);
        return "back/book/bookdetail";
    }
    @RequestMapping(value = "/{bookName}/name/detail",method = RequestMethod.GET
            , produces = "text/json;charset=UTF-8")
    //@ResponseBody
    public String getBookByName(@PathVariable String bookName,Model model)
    {
        Book book=bookService.getByName(bookName);
        model.addAttribute("book",book);
        //logger.info(book.toString());
        //System.out.println(book.toString());
        return "back/book/bookdetail";
    }
    @RequestMapping(value = "/{someName}/sname/detail",method = RequestMethod.GET
            , produces = "text/json;charset=UTF-8")
    //@ResponseBody
    public String getBooksBySomeName(@PathVariable String someName,Model model)
    {
        List<Book> books=bookService.getBySomeName(someName);
//        for (Book book:books) {
//            System.out.println(book.toString());
//        }
        model.addAttribute("books",books);
        return "back/book/booklist";
    }
    @RequestMapping(value = "/{categoryName}/category/detail",method = RequestMethod.GET
            , produces = "text/json;charset=UTF-8")
    //@ResponseBody
    public String getBooksByCategory(@PathVariable String categoryName,Model model)
    {
        List<Book> books=bookService.getByCategory(categoryName);
//        for (Book book:books) {
//            System.out.println(book.toString());
//        }
        model.addAttribute("books",books);
        return "back/book/booklist";
    }
    @RequestMapping(value = "/{author}/author/detail",method = RequestMethod.GET
            , produces = "text/json;charset=UTF-8")
    //@ResponseBody
    public String getBooksByAuthor(@PathVariable String author,Model model)
    {
        List<Book> books=bookService.getByAuthor(author);
//        for (Book book:books) {
//            System.out.println(book.toString());
//        }
        model.addAttribute("books",books);
        return "back/book/booklist";
    }
    @RequestMapping(value = "/{lowPrice}/{highPrice}/detail",method = RequestMethod.GET
            , produces = "text/json;charset=UTF-8")
    //@ResponseBody
    public String getBooksByPrice(@PathVariable Float lowPrice, @PathVariable Float highPrice,Model model)
    {
        List<Book> books=bookService.getByPriceArea(lowPrice,highPrice);
//        for (Book book:books) {
//            System.out.println(book.toString());
//        }
        model.addAttribute("books",books);
        return "back/book/booklist";
    }
    @RequestMapping(value = "/addBook",method = RequestMethod.POST
            , produces = "text/json;charset=UTF-8")
    //@ResponseBody
    public String addBook(@ModelAttribute Book book,Model model)
    {
        book.setCategoryId(categoryService.getByName(book.getCategoryName()).getCategoryId());
        bookService.addBook(book);
        model.addAttribute("book",book);
        return "redirect:/bookstore/"+book.getBookId()+"/id/detail";
    }
    @RequestMapping(value = "/addView",method = RequestMethod.GET)
    public String addView(Model model)
    {
        List<Category> categories=categoryService.getAll();
        model.addAttribute("categories",categories);
        //System.out.println(categories);
        return "back/book/bookadd";
    }
    @RequestMapping(value = "/{bookId}/delete",method = RequestMethod.GET
            , produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String deteteBook(@PathVariable Integer bookId)
    {
        bookService.deleteBookById(bookId);
        return "delete ok";
    }
    @RequestMapping(value = "/updateBook",method = RequestMethod.POST
            , produces = "text/json;charset=UTF-8")
    //@ResponseBody
    public String updateBook(@ModelAttribute Book book)
    {
        bookService.updateBook(book);//"redirect:/"+book.getBookId()+"/id/detail"
        System.out.println(book);
        return "redirect:/bookstore/"+book.getBookId()+"/id/detail";
    }
    @RequestMapping(value = "/{bookId}/updateView",method = RequestMethod.GET
            , produces = "text/json;charset=UTF-8")
    public String updateView(@PathVariable Integer bookId,Model model)
    {
        List<Category> categories=categoryService.getAll();
        model.addAttribute("categories",categories);
        model.addAttribute("book",bookService.getById(bookId));
        return "back/book/bookupdate";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute User user)
    {
        int i=userService.getByUserPass(user);
        if(i==0)
        {
            return "redirect:/bookstore/loginView";
        }
        else {
            return "redirect:/bookstore/index";
        }
    }
    @RequestMapping(value = "/loginView",method = RequestMethod.GET)
    public String loginView()
    {
        return "back/root/login";
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model)
    {
        Map<String,Object> map=new FastHashMap();
        map.put("page",page);
        List<Book> books=bookService.getAllByPage(map);
        model.addAttribute("books",books);
        model.addAttribute("page",page);
        return "back/book/booklist";
    }
    @RequestMapping(value = "/nextPage",method = RequestMethod.GET)
    public String nextPage()
    {
        page.setCurrentPage(page.getCurrentPage()+1);
        page.count();
        return "redirect:/bookstore/index";
    }
    @RequestMapping(value = "/prePage",method = RequestMethod.GET)
    public String prePage()
    {
        page.setCurrentPage(page.getCurrentPage()-1);
        page.count();
        return "redirect:/bookstore/index";
    }
    @RequestMapping(value = "/surePage/{currentPage}",method = RequestMethod.GET)
    //@ResponseBody
    public String surePage(@PathVariable Integer currentPage)
    {
        page.setCurrentPage(currentPage);
        page.count();
        //System.out.println(currentPage);
        return "redirect:/bookstore/index";
    }
    @RequestMapping(value = "/test/bt",method = RequestMethod.GET)
    public String testBootStrap()
    {
        return "test";
    }
}
