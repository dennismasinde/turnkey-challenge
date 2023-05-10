package io.maddennis.turnkeychallenge.repository;

import io.maddennis.turnkeychallenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<List<User>> existsByFirstName(String firstName);
    Optional<List<User>> existsByLastName(String lastName);
}
