package com.mad;

import com.mad.database.entity.Game;
import com.mad.database.entity.School;
import com.mad.database.entity.SchoolSeed;
import com.mad.database.entity.Seed;
import com.mad.database.repository.SeedRepository;
import com.mad.database.service.Services;
import java.io.FileReader;
import static java.lang.Math.toIntExact;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NessApplication.class)
@WebAppConfiguration
public class NessApplicationTests {

    @Autowired
    private Services service;
    @Autowired
    private SeedRepository seedRepo;
    
    @Test
    public void contextLoads() {
    }
    @Test
    @Ignore
    public void createSeeds(){
        for(int i =1; i < 17; i++){
            service.createSeed(i);
        }
        assertTrue(service.getAllSeeds().size() == 16);
    }
    
    @Test
    @Ignore
    public void createSchools(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/Users/plue/Desktop/schoolsJson.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray teams = (JSONArray) jsonObject.get("teams");
            for(int i = 0; i < teams.size(); i ++){
                JSONObject json = (JSONObject) teams.get(i);
                //System.out.println(teams.get(i));
                School s = new School();
                String uni = (String) json.get("region");
                s.setUniversity(uni);
                String na = (String) json.get("name");
                s.setTeamName(na);
                String ab = (String) json.get("abbrev");
                s.setAbbrev(ab);
                service.createSchool(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    @Ignore
    public void CreateASchool(){
        School s = new School();
        s.setId(UUID.randomUUID());
        s.setTeamName("Huskies");
        s.setUniversity("Northeastern");
        s.setAbbrev("PAWS");
        service.createSchool(s);
    }


    @Test
    @Ignore
    public void createSeedsAndGames(){
        List<Game> finalz = new ArrayList<Game>();
        JSONParser parser = new JSONParser();
        
        try {
            Object obj = parser.parse(new FileReader("/Users/plue/Desktop/convertcsv.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray games = (JSONArray) jsonObject.get("games");
            for(int i = 0; i < games.size(); i ++){
                JSONObject json = (JSONObject) games.get(i);
                //System.out.println(teams.get(i));
                Long years =(Long) json.get("Year");
                int year = toIntExact(years);
                String uni = (String) json.get("Team");
                String uni2 = (String) json.get("Team1");
                Long sees = (Long) json.get("Seed");
                int see = toIntExact(sees);
                Long see1s = (Long) json.get("Seed1");
                int see1 = toIntExact(see1s);
                String scos = (String) json.get("Score");
                int sco = Integer.parseInt(scos);   
                String sco2s = (String) json.get("Score1");
                int sco2 = Integer.parseInt(sco2s);
                String rou = (String) json.get("Round");
                Seed one = seedRepo.findBySeed(see);
                Seed two = seedRepo.findBySeed(see1);
                School ons = service.getByUniversity(uni);
                School tws = service.getByUniversity(uni2);
                SchoolSeed ss = new SchoolSeed();
                ss.setSchoolId(ons.getId());
                ss.setSeedId(one.getId());
                ss.setYear(year);
                SchoolSeed sed = service.createSchoolSeed(ss);
                SchoolSeed ss1 = new SchoolSeed();
                ss1.setSchoolId(tws.getId());
                ss1.setSeedId(two.getId());
                ss1.setYear(year);
                SchoolSeed sed1 = service.createSchoolSeed(ss1);
                Game gg = new Game();
                gg.setHome(sed.getId());
                gg.setHomeScore(sco);
                gg.setAway(sed1.getId());
                gg.setAwayScore(sco2);
                gg.setRound(rou);
                Game check = service.createGame(gg);
                if(check.getId() != null){
                    finalz.add(check);
                }
                
            }
            assertTrue(finalz.size() == 2047);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    @Test
//    @Ignore
//    public void updateSchool(){
//        List<School> list = service.getByUniversity("Alabama-Birmingham");
//        if(list.size() > 1){
//            //fail
//            assertTrue(list.size() == 1);
//        } else {
//            list.get(0).setAbbrev("UAB");
//            service.updateSchool(list.get(0));
//        }
//        assertTrue(list.size() == 1);
//    }
}
