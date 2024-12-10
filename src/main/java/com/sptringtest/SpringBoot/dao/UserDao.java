package com.sptringtest.SpringBoot.dao;


import com.sptringtest.SpringBoot.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> showPeople();
    User showUserById(Long id);
    void deleteUserById(Long id);
    void updateUser(Long id, User user);
}
