package br.edu.atitus.apisample.repositories;

import br.edu.atitus.apisample.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
