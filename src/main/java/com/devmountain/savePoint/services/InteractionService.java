package com.devmountain.savePoint.services;

import com.devmountain.savePoint.dtos.InteractionDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface InteractionService {
    //Adding an interaction
    @Transactional
    void addInteraction(InteractionDto interactionDto, Long userId);

    //Deleting an interaction
    @Transactional
    void deleteInteractionById(Long interactionId);

    @Transactional
    void updateInteractionById(InteractionDto interactionDto);

    //Get all notes
    List<InteractionDto> getAllInteractionsByUserId(Long userId);

    //get an interaction by Id
    Optional<InteractionDto> getInteractionById(Long interactionId);
}
