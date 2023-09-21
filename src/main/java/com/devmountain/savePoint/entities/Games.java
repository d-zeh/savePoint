package com.devmountain.savePoint.entities;

import com.devmountain.savePoint.dtos.GamesDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private Integer year_released;

    @Column
    private String studio;

    @Column
    private String platforms;

    @Column
    private Integer rating;

    @Column
    private String sequel_of;

    @Column
    private String prequel_of;

    @ManyToMany(mappedBy = "games")//, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<User> users; // = new HashSet<>();

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Interaction> interactions = new HashSet<>();

    public Games(GamesDto gamesDto) {
        if(gamesDto.getTitle() != null) {
            this.title = gamesDto.getTitle();
        }
        if(gamesDto.getYear_released() != null) {
            this.year_released = gamesDto.getYear_released();
        }
        if(gamesDto.getStudio() != null) {
            this.studio = gamesDto.getStudio();
        }
        if(gamesDto.getPlatforms() != null) {
            this.platforms = gamesDto.getPlatforms();
        }
        if(gamesDto.getRating() != null) {
            this.rating = gamesDto.getRating();
        }
        if(gamesDto.getSequel_of() != null) {
            this.sequel_of = gamesDto.getSequel_of();
        }
        if(gamesDto.getPrequel_of() != null) {
            this.prequel_of = gamesDto.getPrequel_of();
        }
    }
}
