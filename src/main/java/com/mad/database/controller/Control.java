/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mad.database.controller;

import com.mad.database.entity.Seed;
import com.mad.database.service.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author plue
 */
@RestController
public class Control {
    @Autowired
    private Services seedService;

    @RequestMapping(value="seed/getAllSeeds", method=RequestMethod.GET)
    public List<Seed> getAllSeeds(){
       return seedService.getAllSeeds();
    }
}
