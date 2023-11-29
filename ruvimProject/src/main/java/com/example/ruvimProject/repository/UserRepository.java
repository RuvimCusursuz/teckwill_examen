package com.example.ruvimProject.repository;

import com.example.ruvimProject.modell.UserModell;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModell, Integer> {

}
