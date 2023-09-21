package com.devmountain.savePoint.repositories;

import com.devmountain.savePoint.entities.Interaction;
import com.devmountain.savePoint.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long>{
    List<Interaction> findAllByUserEquals(User user);
}
