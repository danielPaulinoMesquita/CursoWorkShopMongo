package com.daniel.workshopmongodb.resources;

import com.daniel.workshopmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User us1= new User("1","Maria Alg", "maria@gmail.com");
        User us2= new User("2","Daniel Alg", "dandan@gmail.com");

        List<User> users= Arrays.asList(us1,us2);

        return  ResponseEntity.ok().body(users);

    }
}
