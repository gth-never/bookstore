package com.bookstore.service.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.User;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by never on 17-3-20.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public int getByUserPass(User user) {
        return userDao.queryByUserPass(user);
    }
}
