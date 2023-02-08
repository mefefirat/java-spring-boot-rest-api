package net.mefe.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.mefe.api.model.User;
import net.mefe.api.service.UserService;


@SpringBootApplication
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/add")
    public @ResponseBody User addNewUser (
            @RequestParam String first_name,
            @RequestParam String last_name) {

        User user = new User();
        user.setFirstName(first_name);
        user.setLastName(last_name);
        return userService.save(user);
    }

    @RequestMapping("/list")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.findAllUsers();
    }

}