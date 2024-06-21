package com.game_love.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game_love.demo.entities.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {
}
