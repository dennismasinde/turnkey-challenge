package io.maddennis.turnkeychallenge.controller;

import io.maddennis.turnkeychallenge.entity.User;
import io.maddennis.turnkeychallenge.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/create",produces = "application/json")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update/{id}",produces = "application/json")
    public ResponseEntity<User> updateUser(@Valid @PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(id,user), HttpStatus.OK);
    }

    @GetMapping(path = "/getuserbyid/{id}", produces = "application/json")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.FOUND);
    }

    @GetMapping(path = "/getuserbyfirstname/{firstName}", produces = "application/json")
    public ResponseEntity<User>  getUserByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(userService.getUserByFirstName(firstName), HttpStatus.FOUND);
    }

    @GetMapping(path = "/getuserbylastname/{lastName}", produces = "application/json")
    public ResponseEntity<User> getUserByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(userService.getUserByLastName(lastName), HttpStatus.FOUND);
    }

    @GetMapping(path = "/getUserAccount", produces = "application/json")
    public ResponseEntity<Integer> getUserAccountNumber(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserAccountNumber(id), HttpStatus.FOUND);
    }

    @GetMapping(path = "/getUserAccCreationDate", produces = "application/json")
    public ResponseEntity<LocalDateTime> getUserAccountCreationDate(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserAccountCreationDate(id), HttpStatus.FOUND);
    }
}
