package com.tecforce.theater.dao;

import com.tecforce.theater.annotations.Users;
import com.tecforce.theater.data.entities.EntityInterface;
import com.tecforce.theater.data.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Users
public class UserDao implements DataDaoInterface{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(EntityInterface entity) {
        sessionFactory.getCurrentSession().save(entity);

    }

    @Override
    public EntityInterface getById(long entityId) {
        return sessionFactory.getCurrentSession().get(User.class, entityId);
    }

    @Override
    public List<EntityInterface> getAll() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> contactRoot = criteria.from(User.class);
        criteria.select(contactRoot);

        return new ArrayList<>(sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
    }

    @Override
    public EntityInterface getEntity(EntityInterface entity) {
        User user = (User) entity;
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.select(root).where(builder.equal(root.get("username"), user.getUsername()));

        List<User> result = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return result.size() == 0 ? null : result.get(0);
    }

    @Override
    public List<EntityInterface> getEntities(EntityInterface entity) {
        return new ArrayList<>();                                                                                               //TODO Дописать
    }

    @Override
    public void update(EntityInterface entity) {}                                                                              //TODO Дописать

    @Override
    public void delete(long entityId) {
        sessionFactory.getCurrentSession().delete(entityId);
    }
}
