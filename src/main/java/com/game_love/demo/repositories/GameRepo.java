package com.game_love.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game_love.demo.entities.Game;

@Repository
public interface GameRepo extends JpaRepository<Game, Long> {
}
