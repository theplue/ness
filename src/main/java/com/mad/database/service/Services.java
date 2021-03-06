/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mad.database.service;

import com.mad.database.entity.Game;
import com.mad.database.entity.School;
import com.mad.database.entity.SchoolSeed;
import com.mad.database.entity.Seed;
import java.util.List;
import java.util.UUID;


/**
 *
 * @author plue
 */
public interface Services {
    List<Seed> getAllSeeds();
    Seed createSeed(int seed);
    List<School> getAllSchools();
    School createSchool(School school);
    School getByUniversity(String university);
    School updateSchool(School school);
    SchoolSeed createSchoolSeed(SchoolSeed schoolSeed);
    Game createGame(Game game);
    List<SchoolSeed> getSchoolSeedHistory(UUID schoolId);
    List<Game> getGamesForSchoolSeed(UUID schoolSeedId);
    List<Game> getGamesByRound(String round);
    List<Game> getGamesBySchoolSeedAndRound(UUID schoolSeedId, String round);
    List<Game> getGamesforYear(int year);
    List<SchoolSeed> getSchoolsForYear(int year);
    List<SchoolSeed> getAllSchoolSeeds();

}
