package com.game_love.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.game_love.demo.entities.Love;
import com.game_love.demo.repositories.projections.LovedGameProjection;
import com.game_love.demo.repositories.projections.MostLovedGameProjection;

@Repository
public interface LoveRepo extends JpaRepository<Love, Long> {

    Optional<Love> findByPlayerIdAndGameId(Long playerId, Long gameId);

    Iterable<LovedGameProjection> findByPlayerId(Long playerId);

    @Query("SELECT love.game.id as gameId, love.game.name as gameName, COUNT(love) as loveCount " +
            "FROM Love love " +
            "GROUP BY love.game.id, love.game.name " +
            "ORDER BY loveCount DESC " +
            "LIMIT :top")
    List<MostLovedGameProjection> findAllProjectedBy(@Param("top") Integer top);

    void deleteByPlayerIdAndGameId(Long playerId, Long gameId);

}
