package com.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.domain.user.UserService;
import com.dto.UserModel;

@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/user")
public class UserController {

    private UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel UserModel) {
        return ResponseEntity.ok( this.UserService.createUser(UserModel) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel UserModel) {
        return ResponseEntity.ok( this.UserService.updateUser(id, UserModel) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok( this.UserService.getUserById(id) );
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserModel> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok( this.UserService.getUserByUsername(username) );
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok( this.UserService.getAllUsers() );
    }

    @GetMapping("/enable/{enable}")
    public ResponseEntity<List<UserModel>> getAllUserByEnable(@PathVariable String enable) {
        return ResponseEntity.ok( this.UserService.getAllUserByEnable(enable) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        UserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
