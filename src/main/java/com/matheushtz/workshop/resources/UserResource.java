package com.matheushtz.workshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.matheushtz.workshop.domain.User;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method=RequestMethod.GET)  
    public ResponseEntity<List<User>> findAll() {
        User u1 = new User("1", "Marcio Jorgensen", "marcio@gmail.com");
        User u2 = new User("2", "Cleberson", "cleberson@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(u1, u2));
        return ResponseEntity.ok(list);
    }
}
