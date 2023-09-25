package com.devmountain.savePoint.controllers;

import com.devmountain.savePoint.dtos.InteractionDto;
import com.devmountain.savePoint.services.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/interactions")
public class InteractionController {
    @Autowired
    private InteractionService interactionService;

    //Gets interactions by users
    @GetMapping("/user/{userId}")
    public List<InteractionDto> getInteractionsByUser(@PathVariable Long userId) {
        return interactionService.getAllInteractionsByUserId(userId);
    }

    //Makes a new interaction
    @PostMapping("/user/{userId}")
    public void addInteraction(@RequestBody InteractionDto interactionDto, @PathVariable Long userId) {
        interactionService.addInteraction(interactionDto, userId);
    }

    //Delete interadtion
    @DeleteMapping("/{interactionId}")
    public void deleteInteractionById(@PathVariable Long interactionId) {
        interactionService.deleteInteractionById(interactionId);
    }

    //update interaction
    @PutMapping
    public void updateInteraction(@RequestBody InteractionDto interactionDto) {
        interactionService.updateInteractionById(interactionDto);
    }
    //Get interaction by interaction id
    @GetMapping("/{interactionId}")
    public Optional<InteractionDto> getInteractionById(@PathVariable Long interactionId){
        return interactionService.getInteractionById(interactionId);
    }
}
