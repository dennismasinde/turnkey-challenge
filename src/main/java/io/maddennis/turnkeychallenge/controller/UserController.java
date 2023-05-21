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

    @PostMapping(path = "/createUser",produces = "application/json")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(path = "/updateUser/{id}",produces = "application/json")
    public ResponseEntity<User> updateUser(@Valid @PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(id,user), HttpStatus.OK);
    }

    @GetMapping(path = "/getUserById/{id}", produces = "application/json")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.FOUND);
    }

    @GetMapping(path = "/getAllUsers",produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers(Integer pageNo, Integer pageSize, String sortBy) {
        return new ResponseEntity<>(userService.getAllUsers(pageNo,pageSize,sortBy), HttpStatus.FOUND);
    }

    @GetMapping(path = "/getUserByFirstName/{firstName}", produces = "application/json")
    public ResponseEntity<User> getUserByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(userService.getUserByFirstName(firstName), HttpStatus.FOUND);
    }

    @GetMapping(path = "/getUserByLastName/{lastName}", produces = "application/json")
    public ResponseEntity<User> getUserByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(userService.getUserByLastName(lastName), HttpStatus.FOUND);
    }

    @GetMapping(path = "/getUserAccount/{id}", produces = "application/json")
    public ResponseEntity<Integer> getUserAccountNumber(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id).getAccountNumber(), HttpStatus.FOUND);
    }

    @GetMapping(path = "/getUserAccCreationDate/{id}", produces = "application/json")
    public ResponseEntity<LocalDateTime> getUserAccountCreationDate(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id).getCreatedAt(), HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return HttpStatus.FORBIDDEN;
    }
}
