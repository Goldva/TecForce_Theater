package com.tecforce.theater.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hall")
public class Hall implements EntityInterface{
    @Id
    @Column(name = "hall_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_hall_id_seq")
    @SequenceGenerator(name = "my_hall_id_seq", sequenceName = "hall_id_seq", allocationSize = 1)
    private long id;
    @Column(name = "hall_name", unique = true)
    private String hallName;
    @Column(name = "ratio_ordinary_place")
    private double ratioOrdinaryPlace;
    @Column(name = "ratio_vip_place")
    private double ratioVipPlace;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "session_hall",
            joinColumns = @JoinColumn(name="hall_id"),
            inverseJoinColumns = @JoinColumn(name = "session_id"))
    @JsonIgnore
    private Set<Session> sessions = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hallPlace",
            cascade = CascadeType.ALL,
            orphanRemoval=true)
    private List<Place> places = new ArrayList<>();

    @Transient
    private double vipPrice;
    @Transient
    private double ordinaryPrice;

    @Override
    public long getId() {
        return id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public double getRatioOrdinaryPlace() {
        return ratioOrdinaryPlace;
    }

    public void setRatioOrdinaryPlace(double ratioOrdinaryPlace) {
        this.ratioOrdinaryPlace = ratioOrdinaryPlace;
    }

    public double getRatioVipPlace() {
        return ratioVipPlace;
    }

    public void setRatioVipPlace(double ratioVipPlace) {
        this.ratioVipPlace = ratioVipPlace;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public double getPriceForPlace(boolean isVip){
        return isVip ? vipPrice : ordinaryPrice;
    }

    public double getOrdinaryPrice() {
        return ordinaryPrice;
    }

    public void setOrdinaryPrice(double ordinaryPrice) {
        this.ordinaryPrice = ordinaryPrice;
    }

    public void addPlace(Place place){
        getPlaces().add(place);
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hall hall = (Hall) o;

        return hallName != null ? hallName.equals(hall.hallName) : hall.hallName == null;
    }

    @Override
    public int hashCode() {
        return hallName != null ? hallName.hashCode() : 0;
    }
}
