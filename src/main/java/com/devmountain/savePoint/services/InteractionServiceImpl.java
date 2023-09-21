package com.devmountain.savePoint.services;


import com.devmountain.savePoint.dtos.InteractionDto;
import com.devmountain.savePoint.entities.Interaction;
import com.devmountain.savePoint.entities.User;
import com.devmountain.savePoint.repositories.InteractionRepository;
import com.devmountain.savePoint.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Create an interaction or game rating
//Delete interaction/remove from lists
//change game from to play to played and add rating
//Call all lists or specifically played list ot to play list
@Service
public class InteractionServiceImpl implements InteractionService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InteractionRepository interactionRepository;

    //Adding an interaction
    @Override
    @Transactional
    public void addInteraction(InteractionDto interactionDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Interaction interaction = new Interaction(interactionDto);
        userOptional.ifPresent(interaction::setUser);
        interactionRepository.saveAndFlush(interaction);
    }

    //Deleting an interaction
    @Override
    @Transactional
    public void deleteInteractionById(Long interactionId) {
        Optional<Interaction> interactionOptional = interactionRepository.findById(interactionId);
        interactionOptional.ifPresent(interaction -> interactionRepository.delete(interaction));
    }
    //Updating interaction

    @Override
    @Transactional
    public void updateInteractionById(InteractionDto interactionDto) {
        Optional<Interaction> interactionOptional = interactionRepository.findById(interactionDto.getId());
        interactionOptional.ifPresent(interaction -> {
            interaction.setPlayed(interactionDto.getPlayed());
            interaction.setTo_play(interactionDto.getTo_play());
            interaction.setRating(interactionDto.getRating());
            interaction.setReview(interactionDto.getReview());
            interactionRepository.saveAndFlush(interaction);
        });
    }

    //Get all notes
    @Override
    public List<InteractionDto> getAllInteractionsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Interaction> interactionList = interactionRepository.findAllByUserEquals(userOptional.get());
            return interactionList.stream().map(interaction -> new InteractionDto(interaction)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    //get an interaction by Id
    @Override
    public Optional<InteractionDto> getInteractionById(Long interactionId) {
        Optional<Interaction> interactionOptional = interactionRepository.findById(interactionId);
        if(interactionOptional.isPresent()) {
            return Optional.of(new InteractionDto(interactionOptional.get()));
        }
        return Optional.empty();
    }

}
