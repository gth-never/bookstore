package com.bookstore.entity;

/**
 * Created by never on 17-3-8.
 */
public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String publisher;
    private float price;
    private String categoryName;//页面展示需要
    private int categoryId;//数据表插入需要
    private String publishTime;
    private int counts;

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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public Book(String bookName, String author, String publisher, float price, String categoryName, String publishTime, int counts) {
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.categoryName = categoryName;
        this.publishTime = publishTime;
        this.counts = counts;
    }

    public Book(int bookId, String bookName, String author, String publisher, float price, int categoryId, String publishTime, int counts) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.categoryId = categoryId;
        this.publishTime = publishTime;
        this.counts = counts;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", categoryName='" + categoryName + '\'' +
                ", categoryId=" + categoryId +
                ", publishTime='" + publishTime + '\'' +
                ", counts=" + counts +
                '}';
    }
}
