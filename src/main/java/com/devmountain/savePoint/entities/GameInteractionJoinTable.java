//package com.devmountain.savePoint.entities;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "gameInteractionJoinTable")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class GameInteractionJoinTable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JsonBackReference
//    private Games game;
//
//    @ManyToOne
//    @JsonBackReference
//    private Interaction interaction;
//}
