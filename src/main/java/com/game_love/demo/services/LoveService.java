package com.game_love.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game_love.demo.entities.Game;
import com.game_love.demo.entities.Love;
import com.game_love.demo.entities.Player;
import com.game_love.demo.repositories.GameRepo;
import com.game_love.demo.repositories.LoveRepo;
import com.game_love.demo.repositories.PlayerRepo;
import com.game_love.demo.repositories.projections.LovedGameProjection;
import com.game_love.demo.repositories.projections.MostLovedGameProjection;

@Service
public class LoveService {

    @Autowired
    private LoveRepo loveRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private GameRepo gameRepo;

    public Love addLove(Long playerId, Long gameId) {
        // NOTE: Added condition to check if player already loves this game
        // Unique constraint on playerId and gameId doesn't seem to work
        if (loveRepo.findByPlayerIdAndGameId(playerId, gameId).isPresent()) {
            throw new RuntimeException("This player already loved this game");
        }

        Player player = playerRepo.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));

        Game game = gameRepo.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));

        Love love = new Love();
        love.setGame(game);
        love.setPlayer(player);

        return loveRepo.save(love);

    }

    public void deleteLove(Long playerId, Long gameId) {
        loveRepo.deleteByPlayerIdAndGameId(playerId, gameId);
    }

    public void deleteLoveById(Long loveId) {
        loveRepo.deleteById(loveId);
    }

    public Iterable<LovedGameProjection> getLovedGamesByPlayer(Long playerId) {
        return loveRepo.findByPlayerId(playerId);
    }

    public List<MostLovedGameProjection> getMostLovedGame(Integer top) {
        return loveRepo.findAllProjectedBy(top)
                .stream()
                .collect(Collectors.toList());
    }
}
