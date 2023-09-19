package com.devmountain.savePoint.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Interactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String user_id;

    @Column
    private String game_id;

    @Column
    private boolean played;

    @Column
    private boolean to_play;

    @Column
    private int rating;

    @Column(columnDefinition = "text")
    private String review;

    @ManyToOne
    @JsonBackReference
    private User user;

}
