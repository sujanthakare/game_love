package com.game_love.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.game_love.demo.controllers.dto.AddLoveRequestDto;
import com.game_love.demo.services.LoveService;

@RestController
@RequestMapping("/api/love")
public class LoveController {

    @Autowired
    private LoveService loveService;

    @PostMapping
    public ResponseEntity<?> addLove(@RequestBody AddLoveRequestDto addLoveRequestDto) {
        try {
            Long playerId = addLoveRequestDto.getPlayerId();
            Long gameId = addLoveRequestDto.getGameId();

            return ResponseEntity.ok(loveService.addLove(playerId, gameId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> removeLove(@RequestParam Long playerId, @RequestParam Long gameId) {
        try {
            loveService.deleteLove(playerId, gameId);
            return ResponseEntity.ok("Love deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{loveId}")
    public ResponseEntity<?> removeLoveById(@PathVariable Long loveId) {
        try {
            if (loveId == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Love id is null");
            }

            loveService.deleteLoveById(loveId);

            return ResponseEntity.ok("Love deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<?> lovedGamesByPlayer(@PathVariable Long playerId) {
        try {
            return ResponseEntity.ok(loveService.getLovedGamesByPlayer(playerId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/most-loved-games")
    public ResponseEntity<?> mostLovedGames(@RequestParam Integer top) {
        try {
            return ResponseEntity.ok(loveService.getMostLovedGame(top));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
