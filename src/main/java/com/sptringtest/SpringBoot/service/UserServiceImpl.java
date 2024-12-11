package com.sptringtest.SpringBoot.service;

import com.sptringtest.SpringBoot.dao.UserDao;
import com.sptringtest.SpringBoot.model.User;
import com.sptringtest.SpringBoot.repositories.PeopleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private final PeopleRepositories peopleRepositories;

    @Autowired
    public UserServiceImpl(PeopleRepositories peopleRepositories) {
        this.peopleRepositories = peopleRepositories;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        peopleRepositories.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> showPeople() {
        return peopleRepositories.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User showUserById(Long id) {
        Optional<User> foundUser = peopleRepositories.findById(id);
        return foundUser.orElse(null);
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        peopleRepositories.deleteById(id);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User updateUser) {
        updateUser.setId(id);
        peopleRepositories.save(updateUser);
    }
}
