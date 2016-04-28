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
@Table(name = "seed", schema="public")
public class Seed implements Serializable {


    @Id
    @Type(type="pg-uuid")
    @Column(name = "id")
    private UUID id;

    @Column(name = "seed")
    private int seed;

    public Seed() {
    }

    public Seed(UUID id) {
        this.id = id;
    }

    public Seed(UUID id, int seed) {
        this.id = id;
        this.seed = seed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

}
