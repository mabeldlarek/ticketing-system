package com.estudos.bel.ticketingsystem.service;

import com.estudos.bel.ticketingsystem.entity.User;
import com.estudos.bel.ticketingsystem.repository.UserRepository;
import com.estudos.bel.ticketingsystem.util.ValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationResponse validationResponse;

    public Iterable<User> list(){
        return userRepository.findAll();
    }

    public ResponseEntity<?> register(User user){
        if(user.getName().equals("")){
            validationResponse.setMessage("Username is require!");
            return new ResponseEntity<ValidationResponse>(validationResponse, HttpStatus.BAD_REQUEST);
        }
        else
            return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }

    public ResponseEntity<?> alter(User user){
        if(user.getName().equals("")){
            validationResponse.setMessage("Username is require!");
            return new ResponseEntity<ValidationResponse>(validationResponse, HttpStatus.BAD_REQUEST);
        }
        else
            return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long id){
        userRepository.deleteById(id);

        validationResponse.setMessage("User deleted successfully");
        return  new ResponseEntity<ValidationResponse>(validationResponse, HttpStatus.OK);

    }
}
