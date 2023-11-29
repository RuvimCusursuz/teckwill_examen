package com.example.ruvimProject.service;

import com.example.ruvimProject.modell.UserModell;
import com.example.ruvimProject.repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserModell> returnAllUsers() {
        log.info("returning all users...");
        return (List<UserModell>) userRepository.findAll();
    }

    public String registerNewUser(UserModell userModell) {
        log.info("Registering a new User...");
        userModell.setUsername(userModell.getName() +userModell.getSurname() + userModell.getDepartment().charAt(0));
        userRepository.save(userModell);
        return "a new user with a name: " + userModell.getName() + " was creating";
    }

    public UserModell returnUserById(Integer id){
        log.info("finding User by Id...");
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public void updateUserById(Integer id, UserModell userModell){
        UserModell testUser = findUserById(id);
        userModell.setId(id);
        userModell.setUsername(testUser.getUsername());
        userModell.setPassword(testUser.getPassword());
        userRepository.save(userModell);
        log.info("updating User with id = " + userModell.getId());
    }

    public void updatePassword(Integer id, String password){
        UserModell userModellTest = findUserById(id);
        userModellTest.setPassword(password);
        userRepository.save(userModellTest);
        log.info("changing password ...");
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }


    private UserModell findUserById(Integer id){
        return userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }
}
