package com.tecforce.theater.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Film {
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
    private int price;

//    @ManyToMany(mappedBy = "films")
//    private Set<Session> sessions = new HashSet<>();

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public Set<Session> getSessions() {
//        return sessions;
//    }
//
//    public void setSessions(Set<Session> sessions) {
//        this.sessions = sessions;
//    }
}
