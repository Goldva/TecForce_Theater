package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class StatisticDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addStatistic(Ticket statistic) {
        sessionFactory.getCurrentSession().save(statistic);
    }

    public List<Ticket> getAllUserStatistics(long userId) {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Ticket> criteria = builder.createQuery(Ticket.class);
        Root<Ticket> contactRoot = criteria.from(Ticket.class);

        criteria.select(contactRoot).where(builder.equal(contactRoot.get("userId"), userId));

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }

    public void deleteStatistic(Ticket statistic) {
        sessionFactory.getCurrentSession().delete(statistic);
    }


}
