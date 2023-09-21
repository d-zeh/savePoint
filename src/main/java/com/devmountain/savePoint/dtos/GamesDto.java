package com.devmountain.savePoint.dtos;

import com.devmountain.savePoint.entities.Games;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamesDto implements Serializable {
    private Long id;
    private String title;
    private Integer year_released;
    private String studio;
    private String platforms;
    private Integer rating;
    private String sequel_of;
    private String prequel_of;

    public GamesDto(Games games) {
        if(games.getId() != null) {
            this.id = games.getId();
        }
        if(games.getTitle() != null) {
            this.title = games.getTitle();
        }
        if(games.getYear_released() != null) {
            this.year_released = games.getYear_released();
        }
        if(games.getStudio() != null) {
            this.studio = games.getStudio();
        }
        if(games.getPlatforms() != null) {
            this.platforms = games.getPlatforms();
        }
        if(games.getRating() != null) {
            this.rating = games.getRating();
        }
        if(games.getSequel_of() != null) {
            this.sequel_of = games.getSequel_of();
        }
        if(games.getPrequel_of() != null) {
            this.prequel_of = games.getPrequel_of();
        }
    }
}
