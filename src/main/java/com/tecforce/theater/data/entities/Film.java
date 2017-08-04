package com.tecforce.theater.data.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "films")
public class Film implements EntityInterface{
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_film_id_seq")
    @SequenceGenerator(name = "my_film_id_seq", sequenceName = "film_id_seq", allocationSize = 1)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private long duration;
    @Column(name = "price")
    private double price;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "film")
    private Set<Session> sessions = new HashSet<>();

    @Override
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Session> getSessions() {
        return sessions;
    }
}
