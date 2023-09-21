package com.devmountain.savePoint.dtos;

import com.devmountain.savePoint.entities.Interaction;
import com.devmountain.savePoint.entities.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private Integer age;
    private Set<InteractionDto> interactionDtoSet = new HashSet<>();

    public UserDto(User user) {
        if(user.getId() != null) {
            this.id = user.getId();
        }
        if(user.getFirst_name() != null) {
            this.first_name = user.getFirst_name();
        }
        if(user.getLast_name() != null) {
            this.last_name = user.getLast_name();
        }
        if(user.getUsername() != null) {
            this.username = user.getUsername();
        }
        if(user.getPassword() != null) {
            this.password = user.getPassword();
        }
        if(user.getAge() != null) {
            this.age = user.getAge();
        }



    }


}
