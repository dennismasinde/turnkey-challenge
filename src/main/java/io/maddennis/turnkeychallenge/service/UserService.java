package io.maddennis.turnkeychallenge.service;

import io.maddennis.turnkeychallenge.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    User updateUser(Long id, User user);
    User getUserById(Long id);
    User getUserByFirstName(String firstName);
    User getUserByLastName(String lastName);
    List<User> getAllUsers(Integer pageNo, Integer pageSize, String sortBy);
    int getUserAccountNumber(Long id);
    LocalDateTime getUserAccountCreationDate(Long id);
    void deleteUserById(Long id);

}
