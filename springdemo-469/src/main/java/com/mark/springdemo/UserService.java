package com.mark.springdemo;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public ApiResponse createUser(User user) {
        return new ApiResponse(
                "User created: " + user.getName(),
                true
        );
    }
}
