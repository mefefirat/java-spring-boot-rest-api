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
import net.mefe.api.repository.UserRepository;


@SpringBootApplication
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String first_name, @RequestParam String last_name) {

        User n = new User();
        n.setFirstName(first_name);
        n.setLastName(last_name);
        userRepository.save(n);
        return "Saved";
    }

    @RequestMapping("/list")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

}