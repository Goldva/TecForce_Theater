package com.tecforce.theater.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @Column(name = "statistics_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_statistics_id_seq")
    @SequenceGenerator(name = "my_statistics_id_seq", sequenceName = "statistics_id_seq", allocationSize = 1)
    private long statisticsId;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "session_id")
    private long sessionId;
    @Column(name = "hall_id")
    private long hallId;
    @Column(name = "place_id")
    private long placeId;
    @Column(name = "price")
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",referencedColumnName="user_id", insertable=false, updatable=false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="session_id",referencedColumnName="session_id", insertable=false, updatable=false)
    private Session session;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="place_id",referencedColumnName="place_id", insertable=false, updatable=false)
    private Place place;

    public long getStatisticsId() {
        return statisticsId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public long getHallId() {
        return hallId;
    }

    public void setHallId(long hallId) {
        this.hallId = hallId;
    }

    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
