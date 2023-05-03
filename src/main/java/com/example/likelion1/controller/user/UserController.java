package com.example.likelion1.controller.user;

import com.example.likelion1.dto.request.UserCreateRequest;
import com.example.likelion1.dto.request.UserUpdateRequest;
import com.example.likelion1.dto.response.UserResponse;
import com.example.likelion1.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(String name) {
        userService.deleteUser(name);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(request);
    }
}
