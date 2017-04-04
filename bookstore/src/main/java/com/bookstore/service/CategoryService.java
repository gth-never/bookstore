package com.bookstore.service;

import com.bookstore.entity.Category;

import java.util.List;

/**
 * Created by never on 17-3-19.
 */
public interface CategoryService {
    Category getById(int categoryId);
    List<Category> getAll();
    Category getByName(String categoryName);
}
