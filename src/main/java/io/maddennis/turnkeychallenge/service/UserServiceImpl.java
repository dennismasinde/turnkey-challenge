package io.maddennis.turnkeychallenge.service;

import io.maddennis.turnkeychallenge.entity.User;
import io.maddennis.turnkeychallenge.exception.NotFoundException;
import io.maddennis.turnkeychallenge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        User newUser = new User(
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getAccountNumber());

        return userRepository.save(newUser);
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
                .orElseThrow(() -> new NotFoundException(
                        "User with id " + id + "does not exist"));
    }

    @Override
    public List<User> getAllUsers(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<User> pagedResult = userRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public User getUserByFirstName(String firstName) {

        return userRepository.findByFirstName(firstName)
                .orElseThrow(() -> new NotFoundException(
                    "User with first name " + firstName + " does not exist"));
    }

    @Override
    public User getUserByLastName(String lastName) {

        return userRepository.findByLastName(lastName)
                .orElseThrow(() -> new NotFoundException(
                        "User with first name " + lastName + " does not exist"));
    }

    @Override
    public int getUserAccountNumber(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get().getAccountNumber();
        } else {
            throw new NotFoundException("User with id " + id + " does not exist");
        }
    }

    @Override
    public LocalDateTime getUserAccountCreationDate(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get().getCreatedAt();
        } else {
            throw new NotFoundException("User with id " + id + " does not exist");
        }
    }
}
