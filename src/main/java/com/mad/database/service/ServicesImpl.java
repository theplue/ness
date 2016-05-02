package com.mad.database.service;

import com.mad.database.entity.Game;
import com.mad.database.entity.School;
import com.mad.database.entity.SchoolSeed;
import com.mad.database.entity.Seed;
import com.mad.database.repository.GameRepository;
import com.mad.database.repository.SchoolRepository;
import com.mad.database.repository.SchoolSeedRepository;
import com.mad.database.repository.SeedRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author plue
 */
@Service
public class ServicesImpl implements Services {
    
    @Autowired
    private SeedRepository seedRepo;
    @Autowired
    private SchoolRepository schoolRepo;
    @Autowired
    private SchoolSeedRepository schoolSeedRepo;
    @Autowired
    private GameRepository gameRepo;

    @Override
    public List<Seed> getAllSeeds() {
        return seedRepo.findAll();
    }

    @Override
    public Seed createSeed(int seed) {
        Seed s = new Seed();
        s.setSeed(seed);
        s.setId(UUID.randomUUID());
        seedRepo.save(s);
        return s;
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }

    @Override
    public School createSchool(School school) {
        school.setId(UUID.randomUUID());
        schoolRepo.save(school);
        return school;
    }

    @Override
    public School getByUniversity(String university) {
        return schoolRepo.findByUniversity(university);
    }

    @Override
    public School updateSchool(School school) {
        schoolRepo.save(school);
        return school;
    }

    @Override
    public SchoolSeed createSchoolSeed(SchoolSeed schoolSeed) {
        UUID id = schoolSeed.getSchoolId();
        int y = schoolSeed.getYear();
                
        SchoolSeed seed = schoolSeedRepo.findBySchoolIdAndYear(id, y);
        if(seed != null){
            return seed;
        } else {
            schoolSeed.initialize();
            return schoolSeedRepo.save(schoolSeed);
            //return schoolSeed;
        }
        
    }

    @Override
    public Game createGame(Game game) {
        game.initialize();
        gameRepo.save(game);
        return game;
    }

    @Override
    public List<SchoolSeed> getSchoolSeedHistory() {
        UUID schoolId = UUID.fromString("bb29359e-c728-46a2-977d-1a9a78c2c15d");
        return schoolSeedRepo.findBySchoolId(schoolId);
    }
}
