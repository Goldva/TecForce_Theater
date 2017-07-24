package com.tecforce.theater.data.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "hall")
public class Hall {
    @Id
    @Column(name = "hall_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_hall_id_seq")
    @SequenceGenerator(name = "my_hall_id_seq", sequenceName = "hall_id_seq", allocationSize = 1)
    private long id;
    @Column(name = "hall_name")
    private String hallName;
    @Column(name = "ratio_ordinary_place")
    private double ratioOrdinaryPlace;
    @Column(name = "ratio_vip_place")
    private double ratioVipPlace;

    @ManyToMany(
            mappedBy = "halls",
            fetch = FetchType.EAGER
    )
    private Set<Session> sessions = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hallPlace")
    private Set<Place> places = new HashSet<>();

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

//    public void addPlace(int countPlace){
//        for (int i = 1; i <= countPlace; i++) {
//            Place place = new Place();
//            place.setPlace(i);
//            place.setHallId(getId());
//            place.setHallPlace(this);
//            places.add(place);
//        }
//    }


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

    public boolean getTypePlace(int numberPlace){
        Place needPlace = new Place();
        needPlace.setHallId(getId());
        needPlace.setPlace(numberPlace);
        Iterator<Place> iterator = places.iterator();
        while (iterator.hasNext()){
            Place place = iterator.next();
            if(needPlace.equals(place)){
                return place.isVipPlace();
            }
        }
        return false;                                           //TODO: Написать и кидать Exception
    }

    public double getRatio(int numberPlace){
        Place searchPlace = new Place();
        searchPlace.setHallId(getId());
        searchPlace.setPlace(numberPlace);
        Place result = null;
        Iterator<Place> iterator = places.iterator();
        while (iterator.hasNext()){
            result = iterator.next();
            if (result.equals(searchPlace)){
                break;
            }
        }
        if (result.isVipPlace()){
            return getRatioVipPlace();
        }else {
            return getRatioOrdinaryPlace();
        }
    }
}
