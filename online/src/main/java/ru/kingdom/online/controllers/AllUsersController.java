package ru.kingdom.online.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kingdom.online.entities.User;
import ru.kingdom.online.repositories.UserRepository;

import java.util.List;
import java.util.StringJoiner;

@RestController(value = "/all")
public class AllUsersController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String showUsers(){
        List<User> users = userRepository.findAll();
        StringBuilder sb = new StringBuilder();
        for (User u: users) {
            sb.append(u.toString()+"<br>");
        }
        return sb.toString();
    }
}
