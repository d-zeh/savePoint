package com.devmountain.savePoint.services;

import com.devmountain.savePoint.dtos.GamesDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface GamesService {
    //Adding a game
    @Transactional
    List<String> addGame(GamesDto gamesDto);

    @Transactional
    void deleteGameById(Long gameId);

    // Pull up (GET) all games byid
    Optional<GamesDto> getGamesById(Long gamesId);
}
