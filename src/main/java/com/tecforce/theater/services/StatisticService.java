package com.tecforce.theater.services;

import com.tecforce.theater.dao.StatisticDao;
import com.tecforce.theater.data.entities.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StatisticService {
    @Autowired
    private StatisticDao statisticDao;

    @Transactional
    public void addStatistic(Statistics statistic) {
        statisticDao.addStatistic(statistic);
    }

    @Transactional
    public List<Statistics> getAllUserStatistics(long userId) {
        return statisticDao.getAllUserStatistics(userId);
    }

    @Transactional
    public void deleteStatistic(Statistics statistic) {
        statisticDao.deleteStatistic(statistic);
    }

}
