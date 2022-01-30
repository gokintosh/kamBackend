package com.gokul.kamfinal.service;

import com.gokul.kamfinal.model.ApiUser;
import com.gokul.kamfinal.model.request.UserCreateRequest;
import com.gokul.kamfinal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public ApiUser readUserByUsername (String username) {
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
    public void createUser(UserCreateRequest userCreateRequest) {
        ApiUser apiUser = new ApiUser();
        Optional<ApiUser> byUsername = userRepository.findByUsername(userCreateRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        apiUser.setUsername(userCreateRequest.getUsername());
        apiUser.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        apiUser.setRole(userCreateRequest.getRole());
        userRepository.save(apiUser);
    }
}
