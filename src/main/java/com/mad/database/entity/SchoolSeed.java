/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mad.database.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author plue
 */
@Entity
@Table(name = "school_seed", schema="public")
public class SchoolSeed implements Serializable {

    @Id
    @Type(type="pg-uuid")
    @Column(name = "id")
    private UUID id;

    @Column(name = "year")
    private int year;
    
    @Column(name="school_id")
    private UUID schoolId;
    
    @Column(name="seed_id")
    private UUID seedId;
    

    public SchoolSeed() {
    }

    public SchoolSeed(UUID id) {
        this.id = id;
    }

    public SchoolSeed(UUID id, int year) {
        this.id = id;
        this.year = year;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public UUID getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(UUID schoolId) {
        this.schoolId = schoolId;
    }

    public UUID getSeedId() {
        return seedId;
    }

    public void setSeedId(UUID seedId) {
        this.seedId = seedId;
    }

    
}
