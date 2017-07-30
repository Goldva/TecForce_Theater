package com.tecforce.theater.services;

import com.tecforce.theater.dao.StatisticDao;
import com.tecforce.theater.data.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class StatisticService {
    @Autowired
    private StatisticDao statisticDao;

    @Transactional
    public void addStatistic(Ticket ticket) {
        statisticDao.addStatistic(ticket);
    }

    @Transactional
    public void addStatistics(Set<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            statisticDao.addStatistic(ticket);
        }
    }

    @Transactional
    public List<Ticket> getAllUserStatistics(long userId) {
        return statisticDao.getAllUserStatistics(userId);
    }

//    @Transactional
//    public void deleteStatistic(Ticket statistic) {
//        statisticDao.deleteStatistic(statistic);
//    }



}
