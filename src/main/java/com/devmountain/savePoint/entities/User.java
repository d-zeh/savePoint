package com.devmountain.savePoint.entities;

import com.devmountain.savePoint.dtos.InteractionDto;
import com.devmountain.savePoint.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private Integer age;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Games> games; // new HashSet<>();


    public User(UserDto userDto) {
        if(userDto.getFirst_name() != null) {
            this.first_name = userDto.getFirst_name();
        }
        if(userDto.getLast_name() != null) {
            this.last_name = userDto.getLast_name();
        }
        if(userDto.getUsername() != null) {
            this.username = userDto.getUsername();
        }
        if(userDto.getPassword() != null) {
            this.password = userDto.getPassword();
        }
        if(userDto.getAge() != null) {
            this.age = userDto.getAge();
        }


    }

}
