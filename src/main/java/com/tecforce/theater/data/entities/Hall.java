package com.tecforce.theater.data.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hall")
public class Hall {
    @Id
    @Column(name = "hall_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_hall_id_seq")
    @SequenceGenerator(name = "my_hall_id_seq", sequenceName = "hall_id_seq")
    private long id;
    @Column(name = "hall_name")
    private String hallName;
    @ElementCollection
    @CollectionTable(name = "ordinaryPlace", joinColumns = @JoinColumn(name = "ordinary_places_id"))
    @Column(name = "ordinary_place")
    private List<Integer> ordinaryPlace;
    @ElementCollection
    @CollectionTable(name = "vipPlace", joinColumns = @JoinColumn(name = "vip_places_id"))
    @Column(name = "vip_place")
    private List<Integer> vipPlace;
    @Column(name = "ratio_ordinary_place")
    private double ratioOrdinaryPlace;
    @Column(name = "ratio_vip_place")
    private double ratioVipPlace;

//    @ManyToOne(optional=false)
//    @JoinColumn(name="user",referencedColumnName="session_id", insertable=false, updatable=false)
//    private Session session;

    public long getId() {
        return id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public List<Integer> getOrdinaryPlace() {
        return ordinaryPlace;
    }

    public void setOrdinaryPlace(List<Integer> ordinaryPlace) {
        this.ordinaryPlace = ordinaryPlace;
    }

    public List<Integer> getVipPlace() {
        return vipPlace;
    }

    public void setVipPlace(List<Integer> vipPlace) {
        this.vipPlace = vipPlace;
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
}
