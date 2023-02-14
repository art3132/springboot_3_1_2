package com.savenkov.spring.springboot.springboot_3_1_2.dao;

import com.savenkov.spring.springboot.springboot_3_1_2.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User");
        return (List<User>) query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        User newUser = entityManager.merge(user);
        user.setId(newUser.getId());
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        Query query = entityManager.createQuery("delete from User where id =: userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
