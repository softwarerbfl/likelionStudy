package com.example.likelion1.service.user;

import com.example.likelion1.domain.user.User;
import com.example.likelion1.dto.request.UserCreateRequest;
import com.example.likelion1.dto.request.UserUpdateRequest;
import com.example.likelion1.dto.response.UserResponse;
import com.example.likelion1.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest request){
        User user = new User(request.getName(), request.getAge());
        userRepository.save(user);
    }

    public void deleteUser(String name){
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);
    }

    public List<UserResponse> getUsers(){
        List<UserResponse> users = userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .collect(Collectors.toList());
        return users;
    }

    public void updateUser(UserUpdateRequest request){
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        user.setName(request.getName());
        userRepository.save(user);
    }
}
