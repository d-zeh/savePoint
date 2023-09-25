package com.devmountain.savePoint.services;

import com.devmountain.savePoint.dtos.GamesDto;
import com.devmountain.savePoint.entities.Games;
import com.devmountain.savePoint.repositories.GamesRepository;
import com.devmountain.savePoint.repositories.InteractionRepository;
import com.devmountain.savePoint.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GamesServiceImpl implements GamesService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InteractionRepository interactionRepository;
    @Autowired
    private GamesRepository gamesRepository;

    //Adding a game
    @Override
    @Transactional
    public List<String> addGame(GamesDto gamesDto) {
        List<String> response = new ArrayList<>();
        Games games = new Games(gamesDto);
        gamesRepository.saveAndFlush(games);
        response.add("Game has been added to savePoint");
        return response;
    }
    //Delete a game

    @Override
    @Transactional
    public void deleteGameById(Long gameId) {
        Optional<Games> gamesOptional = gamesRepository.findById(gameId);
        gamesOptional.ifPresent(games -> gamesRepository.delete(games));
    }

    // Pull up (GET) all games byid
    @Override
    public Optional<GamesDto> getGamesById(Long gamesId) {
        Optional<Games> gamesOptional = gamesRepository.findById(gamesId);
        if(gamesOptional.isPresent()) {
            return  Optional.of(new GamesDto(gamesOptional.get()));
        }
        return Optional.empty();
    }



}
