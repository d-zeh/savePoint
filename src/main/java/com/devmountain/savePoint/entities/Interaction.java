package com.devmountain.savePoint.entities;

import com.devmountain.savePoint.dtos.InteractionDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Interactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column
//    private String user_table_id;
//
//    @Column
//    private String game_table_id;

    @Column
    private Boolean played;

    @Column
    private Boolean to_play;

    @Column
    private Integer rating;

    @Column(columnDefinition = "text")
    private String review;

    @ManyToOne
    @JsonBackReference
    private User user;

    //@ManyToMany(mappedBy = "interaction", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    //@JsonManagedReference
    //private Set<GameInteractionJoinTable> gameInteractionSet = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.ALL})
    private Games game;

    public Interaction(InteractionDto interactionDto) {
        if(interactionDto.getPlayed() != null) {
            this.played = interactionDto.getPlayed();
        }
        if(interactionDto.getTo_play() != null) {
            this.to_play = interactionDto.getTo_play();
        }
        if(interactionDto.getRating() != null) {
            this.rating = interactionDto.getRating();
        }
        if(interactionDto.getReview() != null) {
            this.review = interactionDto.getReview();
        }
    }


}
