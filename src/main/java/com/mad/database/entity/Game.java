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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author plue
 */
@Entity
@Table(name = "game", schema="public")
public class Game implements Serializable {


    @Id
    @Type(type="pg-uuid")
    @Column(name = "id")
    private UUID id;
   
    @Column(name = "home_score")
    private int homeScore;

    @Column(name = "away_score")
    private int awayScore;

    @Column(name = "round")
    private String round;
    
    @Column(name = "overtime")
    private Boolean overtime;

    @Type(type="pg-uuid")
    @Column(name="home")
    private UUID home;
    
    @JoinColumn(name = "home", referencedColumnName = "id", insertable=false, updatable=false)
    @ManyToOne
    private School homeSchool;
    
    @Type(type="pg-uuid")
    @Column(name="away")
    private UUID away;

    @JoinColumn(name = "away", referencedColumnName = "id", insertable=false, updatable=false)
    @ManyToOne
    private School awaySchool;
    
    public Game() {
    }

    public void initialize(){
        this.id = UUID.randomUUID();
        this.overtime= false;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public Boolean getOvertime() {
        return overtime;
    }

    public void setOvertime(Boolean overtime) {
        this.overtime = overtime;
    }

    public UUID getHome() {
        return home;
    }

    public void setHome(UUID home) {
        this.home = home;
    }

    public UUID getAway() {
        return away;
    }

    public void setAway(UUID away) {
        this.away = away;
    }

    public School getHomeSchool() {
        return homeSchool;
    }

    public void setHomeSchool(School homeSchool) {
        this.homeSchool = homeSchool;
    }

    public School getAwaySchool() {
        return awaySchool;
    }

    public void setAwaySchool(School awaySchool) {
        this.awaySchool = awaySchool;
    }
   
}
