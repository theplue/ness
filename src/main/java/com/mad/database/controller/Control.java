/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mad.database.controller;

import com.mad.database.entity.Game;
import com.mad.database.entity.School;
import com.mad.database.entity.SchoolSeed;
import com.mad.database.entity.Seed;
import com.mad.database.service.Services;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author plue
 */
@RestController
public class Control {
    
    @Autowired
    private Services service;

    @RequestMapping(value="seed/getAllSeeds", method=RequestMethod.GET)
    public List<Seed> getAllSeeds(){
        List<Seed> test = service.getAllSeeds();
        System.out.println(test);
       return test;
    }
    
    @RequestMapping(value="school/getAllSchools", method=RequestMethod.GET)
    public List<School> getAllSchools(){
        return service.getAllSchools();
    }
    
    @RequestMapping(value="school/getSchoolsForYear", method=RequestMethod.GET)
    public List<SchoolSeed> getSchoolsForYear(@RequestParam(value="year")int year){
        return service.getSchoolsForYear(year);
    }
    
    @RequestMapping(value="school/getAllSchoolSeeds", method=RequestMethod.GET)
    public List<SchoolSeed> getAllSchoolSeeds(){
        return service.getAllSchoolSeeds();
    }
    
    @RequestMapping(value="game/getGamesForYear", method=RequestMethod.GET)
    public List<Game> getGamesForYear(@RequestParam(value="year") int year){
        return service.getGamesforYear(year);
    }
    
    @RequestMapping(value="school/getSchoolSeedHistory", method=RequestMethod.GET)
    public List<SchoolSeed> gethSchoolSeedHistory(@RequestParam(value="schoolId") UUID schoolId){
        return service.getSchoolSeedHistory(schoolId);
    }
    
    @RequestMapping(value="game/getGamesForRound", method=RequestMethod.GET)
    public List<Game> getGamesForRound(@RequestParam(value="round") String round){
        return service.getGamesByRound(round);
    }
    
    @RequestMapping(value="game/getGamesForSchoolSeed", method=RequestMethod.GET)
    public List<Game> getGamesforSchoolSeed(@RequestParam(value="schoolSeedId") UUID schoolSeedId){
        return service.getGamesForSchoolSeed(schoolSeedId);
    }
    
    @RequestMapping(value="game/getGameforSchoolSeedAndRound", method=RequestMethod.GET)
    public List<Game> getGameForSchoolSeedAndRound(@RequestParam(value="schoolSeedId") UUID schoolSeedId, 
            @RequestParam(value="round") String round){
        return service.getGamesBySchoolSeedAndRound(schoolSeedId, round);
    }
}
