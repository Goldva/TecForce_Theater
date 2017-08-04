package com.tecforce.theater.dao;

import com.tecforce.theater.annotations.Statistics;
import com.tecforce.theater.data.entities.EntityInterface;
import com.tecforce.theater.data.entities.Ticket;
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
@Statistics
public class StatisticDao implements DataDaoInterface{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(EntityInterface entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public EntityInterface getById(long entityId) {
        return new Ticket();                                                                                                //TODO Дописать
    }

    @Override
    public List<EntityInterface> getAll() {
        return new ArrayList<>();                                                                                           //TODO Дописать
    }

    @Override
    public EntityInterface getEntity(EntityInterface entity) {
        return new Ticket();                                                                                                //TODO Дописать
    }

    @Override
    public List<EntityInterface> getEntities(EntityInterface entity) {
        User user = (User)entity;
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Ticket> criteria = builder.createQuery(Ticket.class);
        Root<Ticket> contactRoot = criteria.from(Ticket.class);

        criteria.select(contactRoot).where(builder.equal(contactRoot.get("userId"), user.getId()));

        return new ArrayList<>(sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
    }

    @Override
    public void update(EntityInterface entity) {}                                                                             //TODO Дописать

    @Override
    public void delete(long entityId) {
        sessionFactory.getCurrentSession().delete(entityId);
    }
}
