package com.poc.springproject.dao;

import com.poc.springproject.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public synchronized void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public synchronized List<User> listUsers() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> getUsersQuery = sessionFactory.getCurrentSession().createQuery("from User");
        return getUsersQuery.getResultList();
    }

    public synchronized User getUserById(long id) {
        String hql = "FROM User U WHERE U.id = :user_id";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("user_id", id);
        return (User) query.getSingleResult();
    }

    @Override
    public int deleteUser(long id) {
        String hql = "DELETE FROM User WHERE id = :user_id";
        Query query = sessionFactory.getCurrentSession().createQuery(hql)
                .setParameter("user_id", id);
        return query.executeUpdate();
    }

    @Override
    public int updateUser(User user, long id) {
        String hql = "UPDATE User set name = :name, middlename = :middlename, lastname = :lastname, " +
                "age = :age, email = :email" +
                " WHERE id = :user_id";
        Query query = sessionFactory.getCurrentSession().createQuery(hql)
                .setParameter("name", user.getName())
                .setParameter("middlename", user.getMiddleName())
                .setParameter("lastname", user.getLastname())
                .setParameter("age", user.getAge())
                .setParameter("email", user.getEmail())
                .setParameter("user_id", id);
        return query.executeUpdate();
    }

}
