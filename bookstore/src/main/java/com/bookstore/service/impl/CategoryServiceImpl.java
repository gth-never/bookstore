package com.bookstore.service.impl;

import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Category;
import com.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by never on 17-3-19.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public Category getById(int categoryId) {
        return categoryDao.queryById(categoryId);
    }

    public List<Category> getAll() {
        return categoryDao.queryAll();
    }

    public Category getByName(String categoryName) {
        return categoryDao.queryByName(categoryName);
    }
}
