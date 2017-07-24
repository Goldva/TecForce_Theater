package com.tecforce.theater.dao;

import com.tecforce.theater.data.entities.Statistics;
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

    public void addStatistic(Statistics statistic) {
        sessionFactory.getCurrentSession().save(statistic);
    }

    public List<Statistics> getAllUserStatistics(long userId) {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Statistics> criteria = builder.createQuery(Statistics.class);
        Root<Statistics> contactRoot = criteria.from(Statistics.class);

        criteria.select(contactRoot).where(builder.equal(contactRoot.get("userId"), userId));

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }

    public void deleteStatistic(Statistics statistic) {
        sessionFactory.getCurrentSession().delete(statistic);
    }


}
