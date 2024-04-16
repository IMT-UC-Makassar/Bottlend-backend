package com.rvm.rvm.controller;

import com.rvm.rvm.entity.User;
import com.rvm.rvm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUser() {
        Iterable<User> users = userRepository.findAll();
        if (!users.iterator().hasNext()) {
            return new ResponseEntity<>(users, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> updateUserById(@PathVariable String email, @RequestBody User newUser) {
        if(userRepository.existsById(email)) {
            User oldUser = userRepository.findById(email).get();
            oldUser.setPoint_total(newUser.getPoint_total());
            oldUser.setUang(newUser.getUang());
            userRepository.save(oldUser);
            return new ResponseEntity<>(oldUser, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
}
