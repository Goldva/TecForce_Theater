package com.tecforce.theater.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sessions",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"film_id", "time"})})
public class Session implements EntityInterface{
    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_session_id_seq")
    @SequenceGenerator(name = "my_session_id_seq", sequenceName = "session_id_seq", allocationSize = 1)
    private long id;
    @Column(name = "film_id")
    private long filmId;
    @Column(name = "time")                          //TODO Подумать над продолжительностью
    private Time time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="film_id",referencedColumnName="film_id", insertable=false, updatable=false)
    @JsonIgnore
    private Film film;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "session_hall",
            joinColumns = {@JoinColumn(name="session_id")},
            inverseJoinColumns = {@JoinColumn(name = "hall_id")})
    private Set<Hall> halls = new HashSet<>();

    @Override
    public long getId() {
        return id;
    }

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @JsonIgnore
    public double getPrice() {
        return film.getPrice();
    }

    public Set<Hall> getHalls() {
        return halls;
    }

    public void setHalls(Set<Hall> halls) {
        this.halls = halls;
    }

    public void addHall(Hall hall){
        getHalls().add(hall);
    }

}
