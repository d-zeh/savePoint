package com.devmountain.savePoint.dtos;

//import com.devmountain.savePoint.entities.GameInteractionJoinTable;
import com.devmountain.savePoint.entities.Interaction;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InteractionDto implements Serializable {
    private Long id;
    private String user_table_id;
    private String game_table_id;
    private Boolean played;
    private Boolean to_play;
    private Integer rating;
    private String review;

    public InteractionDto(Interaction interaction) {

        if(interaction.getId() != null) {
            this.id = interaction.getId();
        }
//        if(interaction.getUser_table_id() != null) {
//            this.user_table_id = interaction.getUser_table_id();
//        }
//        if(interaction.getGame_table_id() != null) {
//            this.game_table_id = interaction.getGame_table_id();
//        }
        if(interaction.getPlayed() != null) {
            this.played = interaction.getPlayed();
        }
        if(interaction.getTo_play() != null) {
            this.to_play = interaction.getTo_play();
        }
        if(interaction.getRating() != null) {
            this.rating = interaction.getRating();
        }
        if(interaction.getReview() != null) {
            this.review = interaction.getReview();
        }
    }

}
