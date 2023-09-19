package com.devmountain.savePoint.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int year_released;

    @Column
    private String studio;

    @Column
    private String platforms;

    @Column
    private int rating;

    @Column
    private String sequel_of;

    @Column
    private String prequel_of;
}
