package com.tecforce.theater.data.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_session_id_seq")
    @SequenceGenerator(name = "my_session_id_seq", sequenceName = "session_id_seq")
    private long id;
    @Column(name = "film_id")
    private long filmId;
    @Column(name = "time")
    private Time time;
    @Column(name = "hall_id")
    private long hallId;
    @Column(name = "price")
    private int price;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "session_films",
            joinColumns = {@JoinColumn(name = "session_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")})
    private Set<Film> film;

    @OneToMany(mappedBy = "sessions")
    private Set<Hall> halls;




}
