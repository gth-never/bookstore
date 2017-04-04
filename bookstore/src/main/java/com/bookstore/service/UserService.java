package com.bookstore.service;

import com.bookstore.entity.User;

/**
 * Created by never on 17-3-20.
 */
public interface UserService {
    int getByUserPass(User user);
}
