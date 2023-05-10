package io.maddennis.turnkeychallenge.service;

import io.maddennis.turnkeychallenge.entity.User;
import io.maddennis.turnkeychallenge.exception.ResourceNotFoundException;
import io.maddennis.turnkeychallenge.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        User user1 = new User();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setAccountNumber(user.getAccountNumber());
        user1.setCreatedAt(LocalDateTime.now());
        user1.setModifiedAt(LocalDateTime.now());
        return userRepository.save(user1);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userDB = getUserById(id);

        userDB.setFirstName(user.getFirstName());
        userDB.setLastName(user.getLastName());
        userDB.setPhoneNumber(user.getPhoneNumber());
        userDB.setModifiedAt(LocalDateTime.now());

        userRepository.save(userDB);
        return userDB;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + "does not exist"));
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        return userRepository
                .existsByFirstName(firstName)
                .orElseThrow(() -> new ResourceNotFoundException("User with first name " + firstName + "does not exist"));
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        return userRepository
                .existsByLastName(lastName)
                .orElseThrow(() -> new ResourceNotFoundException("User with first name " + lastName + "does not exist"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public int getUserAccountNumber(Long id) {
        User userDB = userRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
        return userDB.getAccountNumber();
    }

    @Override
    public LocalDateTime getUserAccountCreationDate(Long id) {
        User userDB = userRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException(""));
        return userDB.getCreatedAt();
    }
}
