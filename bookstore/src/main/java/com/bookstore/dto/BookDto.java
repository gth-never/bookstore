package com.bookstore.dto;

import com.bookstore.entity.Book;

/**
 * Created by never on 17-3-19.
 */
public class BookDto {
    private int bookId;
    private String bookName;
    private String author;
    private String publisher;
    private float price;
    private String categoryName;
    private String publishTime;
    private int counts;
    //放弃使用这种方式 如果将Dao层返回的Book对象在service层转换蔚dto的BookDto对象的话
    //service层会多出很多重复代码，对于每一个查询出来的Book对象都要转换，麻烦。
    public BookDto(int bookId, String bookName, String author, String publisher, float price, String categoryName, String publishTime, int counts) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.categoryName = categoryName;
        this.publishTime = publishTime;
        this.counts = counts;
    }

    public BookDto() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", categoryName='" + categoryName + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", counts=" + counts +
                '}';
    }
}
