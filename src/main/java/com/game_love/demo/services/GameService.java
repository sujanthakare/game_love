package com.game_love.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game_love.demo.entities.Game;
import com.game_love.demo.repositories.GameRepo;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    public Iterable<Game> getAllGames() {
        return gameRepo.findAll();
    }
}
