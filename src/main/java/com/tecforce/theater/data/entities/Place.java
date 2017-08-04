package com.tecforce.theater.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "places",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"place", "hall_id"})})
public class Place implements EntityInterface{
    @Id
    @Column(name = "place_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_places_id_seq")
    @SequenceGenerator(name = "my_places_id_seq", sequenceName = "places_id_seq", allocationSize = 1)
    private long id;
    @Column(name = "place")
    private int place;
    @Column(name = "hall_id")
    private long hallId;
    @Column(name = "vip_place")
    private boolean vipPlace = false;

    @ManyToOne(optional=false)
    @JoinColumn(name="hall_id",referencedColumnName="hall_id", insertable=false, updatable=false)
    @JsonIgnore
    private Hall hallPlace;

    @Override
    public long getId() {
        return id;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public long getHallId() {
        return hallId;
    }

    public void setHallId(long hallId) {
        this.hallId = hallId;
    }

    public boolean isVipPlace() {
        return vipPlace;
    }

    public void setVipPlace(boolean vipPlace) {
        this.vipPlace = vipPlace;
    }

    public Hall getHallPlace() {
        return hallPlace;
    }

    public void setHallPlace(Hall hallPlace) {
        this.hallPlace = hallPlace;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place1 = (Place) o;

        if (place != place1.place) return false;
        return hallId == place1.hallId;
    }

    @Override
    public int hashCode() {
        int result = place;
        result = 31 * result + (int) (hallId ^ (hallId >>> 32));
        return result;
    }

}
