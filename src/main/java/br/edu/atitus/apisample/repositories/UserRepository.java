package br.edu.atitus.apisample.repositories;

import br.edu.atitus.apisample.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository //Somente a título de informação
public interface UserRepository extends JpaRepository<User, UUID> {
    //save
    //findAll
    //findById
    //deleteById
    //delete
}