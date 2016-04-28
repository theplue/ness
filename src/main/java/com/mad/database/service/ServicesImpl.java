package com.mad.database.service;

import com.mad.database.entity.School;
import com.mad.database.entity.Seed;
import com.mad.database.repository.SchoolRepository;
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
    public List<School> getByUniversity(String university) {
        return schoolRepo.findByUniversity(university);
    }

    @Override
    public School updateSchool(School school) {
        schoolRepo.save(school);
        return school;
    }
}
