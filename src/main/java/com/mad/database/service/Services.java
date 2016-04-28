/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mad.database.service;

import com.mad.database.entity.School;
import com.mad.database.entity.Seed;
import java.util.List;


/**
 *
 * @author plue
 */
public interface Services {
    List<Seed> getAllSeeds();
    Seed createSeed(int seed);
    List<School> getAllSchools();
    School createSchool(School school);
    List<School> getByUniversity(String university);
    School updateSchool(School school);
}
