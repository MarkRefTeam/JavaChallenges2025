package com.mark.springdemo;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hi " + name + ":D";
    }

    @PostMapping("/user")
    public ApiResponse createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
}
