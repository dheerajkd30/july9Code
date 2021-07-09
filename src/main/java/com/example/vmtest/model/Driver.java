package com.example.vmtest.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Driver {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String driverId;

    @Column
    @OneToMany(mappedBy="Cab")
    private Set<Cab> cabs;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Cab> getCabs() {
        return cabs;
    }

    public void setCabs(Set<Cab> cabs) {
        this.cabs = cabs;
    }

}
