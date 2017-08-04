package com.tecforce.theater.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements EntityInterface{
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_role_id_seq")
    @SequenceGenerator(name = "my_role_id_seq", sequenceName = "role_id_seq", allocationSize = 1)
    private long id;
    @Column(name = "role")
    private String role;

    @Override
    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
