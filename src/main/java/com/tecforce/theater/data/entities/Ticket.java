package com.tecforce.theater.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "statistics")
public class Ticket implements EntityInterface{
    @Id
    @Column(name = "statistics_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_statistics_id_seq")
    @SequenceGenerator(name = "my_statistics_id_seq", sequenceName = "statistics_id_seq", allocationSize = 1)
    private long id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "session_id")
    private long sessionId;
    @Column(name = "hall_id")
    private long hallId;
    @Column(name = "place_id")
    private long placeId;
    @Column(name = "price")
    private double price;

    @Transient
    private boolean is6ThTicket;
    @Transient
    private boolean is10ThTicket;
    @Transient
    private List<String> stocks = new ArrayList<>();
    @Transient
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id", referencedColumnName = "hall_id", insertable = false, updatable = false)
    private Hall hall;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "session_id", referencedColumnName = "session_id", insertable = false, updatable = false)
    private Session session;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id", referencedColumnName = "place_id", insertable = false, updatable = false)
    private Place place;

    @Override
    public long getId() {
        return id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = new BigDecimal(price).setScale(2, RoundingMode.UP).doubleValue();                          //TODO Перенести округление
    }

    public List<String> getStocks() {
        return stocks;
    }

    public boolean isIs6ThTicket() {
        return is6ThTicket;
    }

    public boolean isIs10ThTicket() {
        return is10ThTicket;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}