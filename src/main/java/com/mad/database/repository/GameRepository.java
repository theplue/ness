/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mad.database.repository;

import com.mad.database.entity.Game;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author plue
 */
public interface GameRepository extends JpaRepository<Game, UUID>{
    List<Game> findByHomeAndAway(UUID home, UUID away);
    List<Game> findByRound(String round);
    List<Game> findByHomeAndAwayAndRound(UUID home, UUID away, String round);
}
