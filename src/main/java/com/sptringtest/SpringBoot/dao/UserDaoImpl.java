package com.sptringtest.SpringBoot.dao;

import com.sptringtest.SpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    public List<User> showPeople() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public User showUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = showUserById(id);
        if(user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void updateUser(Long id, User updateUser) {
        entityManager.merge(updateUser);
    }
}
