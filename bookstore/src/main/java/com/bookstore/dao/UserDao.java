package com.bookstore.dao;

import com.bookstore.entity.User;

/**
 * Created by never on 17-3-20.
 */
public interface UserDao {
    int queryByUserPass(User user);
}
