package com.game_love.demo.repositories.projections;

public interface MostLovedGameProjection {
    Long getGameId();

    String getGameName();

    Long getLoveCount();
}
