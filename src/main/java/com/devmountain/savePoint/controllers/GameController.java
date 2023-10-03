package com.devmountain.savePoint.controllers;

import com.devmountain.savePoint.dtos.GamesDto;
import com.devmountain.savePoint.dtos.InteractionDto;
import com.devmountain.savePoint.services.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/games")
public class GameController {
    @Autowired
    private GamesService gamesService;

    //Get a game
    @GetMapping("/{gameId}")
    public Optional<GamesDto> getGamesById(@PathVariable Long gameId){
        return gamesService.getGamesById(gameId);
    }


    //Makes a new game
    @PostMapping("/newGame")
    public List<String> addGame(@RequestBody GamesDto gamesDto){
        return gamesService.addGame(gamesDto);
    }

    //Delete a game from the database
    @DeleteMapping("/{gameId}")
    public void deleteGameById(@PathVariable Long gameId) {
        gamesService.deleteGameById(gameId);
    }
    //Add a game to an interaction
    //when the game is pulled up and the button is hit,
    //this function will take the gameDto and return its id
    //then add it along the interaction when it is made then
    //stored

}
