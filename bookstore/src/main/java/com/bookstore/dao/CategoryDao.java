package com.bookstore.dao;

import com.bookstore.entity.Category;

import java.util.List;

/**
 * Created by never on 17-3-19.
 */
public interface CategoryDao {
    Category queryById(int categoryId);
    List<Category> queryAll();
    Category queryByName(String categoryName);
}
