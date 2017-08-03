package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User getUserById(long userId) {
        return sessionFactory.getCurrentSession().get(User.class, userId);
    }

    public User getUserByLogin(String login) {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.select(root).where(builder.equal(root.get("username"), login));

        List<User> result = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return result.size() == 0 ? null : result.get(0);
    }

    public List<User> getAllUsers() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> contactRoot = criteria.from(User.class);
        criteria.select(contactRoot);

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }

    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

}
