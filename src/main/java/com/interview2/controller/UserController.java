package com.interview2.controller;

import com.interview2.entity.User;
import com.interview2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//    CURD operation --
@RestController
public class UserController {
    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }


    //    create -- means post request
    @PostMapping
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }
//    update -- means put request
    @PutMapping("/{id}")
    public Optional<User> updateUser(@PathVariable @Validated Integer id, @RequestBody User userRequest) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(userRequest.getName());
                    user.setEmail(userRequest.getEmail());
                    user.setPassword(userRequest.getPassword());
                    return repository.save(user);
                });
}
//    Read -- means get request
    @GetMapping("/allUsers")
    public List<User> getAllUser() {
    return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable @Validated Integer id) {
        return repository.findById(id);
    }
//    Delete --means delete request
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable @Validated Integer id) {
        repository.deleteById(id);
    }

}
