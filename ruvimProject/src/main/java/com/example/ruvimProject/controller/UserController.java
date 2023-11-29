package com.example.ruvimProject.controller;

import com.example.ruvimProject.modell.UserModell;
import com.example.ruvimProject.repository.UserRepository;
import com.example.ruvimProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/api/users/all")
    public ResponseEntity<List<UserModell>> returnAllusers(){
        return ResponseEntity.ok(userService.returnAllUsers());
    }

    @PostMapping("/api/register")
    public ResponseEntity<String> registerNewUser(@Valid @RequestBody UserModell userModell){
        return ResponseEntity.ok(userService.registerNewUser(userModell));
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<UserModell> returnById (@PathVariable Integer id){
        return ResponseEntity.ok( userService.returnUserById(id));
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<String> updateById(@PathVariable Integer id, @Valid @RequestBody UserModell userModell){
    userService.updateUserById(id, userModell);
    return ResponseEntity.ok("Update is successful by Id: " + userModell.getId());
    }

    @PutMapping("/api/user/password/{id}")
    public ResponseEntity<String> updatePassword(@PathVariable Integer id, @RequestBody String newPassword){
        userService.updatePassword(id, newPassword);
        return ResponseEntity.ok("password are changed");
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        userService.deleteById(id);
        return ResponseEntity.ok("user with Id: " + id + " was deleted");
    }
}
