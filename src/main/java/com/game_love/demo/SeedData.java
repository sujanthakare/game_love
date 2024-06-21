package com.game_love.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game_love.demo.entities.Game;
import com.game_love.demo.entities.Player;
import com.game_love.demo.repositories.GameRepo;
import com.game_love.demo.repositories.PlayerRepo;

import jakarta.annotation.PostConstruct;

@Service
public class SeedData {

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private GameRepo gameRepo;

    @PostConstruct
    public void seedData() {

        if (playerRepo.findAll().isEmpty()) {
            Player player = new Player("John");
            playerRepo.save(player);

            Player player2 = new Player("Jane");
            playerRepo.save(player2);

            Player player3 = new Player("Maria");
            playerRepo.save(player3);

            Player player4 = new Player("Peter");
            playerRepo.save(player4);

        }

        if (gameRepo.findAll().isEmpty()) {
            Game game = new Game("War of the worlds");
            gameRepo.save(game);

            Game game2 = new Game("Battleship");
            gameRepo.save(game2);

            Game game3 = new Game("Call of duty");
            gameRepo.save(game3);

            Game game4 = new Game("Super mario");
            gameRepo.save(game4);
        }
    }
}
