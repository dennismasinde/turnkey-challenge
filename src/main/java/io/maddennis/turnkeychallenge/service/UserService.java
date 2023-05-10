package io.maddennis.turnkeychallenge.service;

import io.maddennis.turnkeychallenge.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {

    User createUser(User user);
    User updateUser(Long id, User user);
    User getUserById(Long id);
    List<User> getUserByFirstName(String firstName);
    List<User> getUserByLastName(String lastName);
    List<User> getAllUsers();
    int getUserAccountNumber(Long id);
    LocalDateTime getUserAccountCreationDate(Long id);

}
