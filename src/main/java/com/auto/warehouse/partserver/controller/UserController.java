package com.auto.warehouse.partserver.controller;

import com.auto.warehouse.partserver.entity.User;
import com.auto.warehouse.partserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(path = "/pts")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String name){
        try{
            List<User> users = new ArrayList<>();

            if(name == null){
                userRepository.findAll().forEach(users::add);
            }else{
                userRepository.findByName(name).forEach(users::add);
            }

            if(users.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/users/{name}")
    public ResponseEntity<List<User>> getUserByName(@PathVariable("name") String name){
        List<User> userData = userRepository.findByName(name);

        if (!userData.isEmpty()) {
            return new ResponseEntity<>(userData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> newUser(@RequestBody User user){
        try{
            User _user = userRepository.save(new User(user.getName(), user.getEmail(), user.getTel(), user.getDescription(), user.getPwd()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
