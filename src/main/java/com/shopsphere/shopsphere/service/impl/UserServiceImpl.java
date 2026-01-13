package com.shopsphere.shopsphere.service.impl;

import com.shopsphere.shopsphere.dto.UserRequestDto;
import com.shopsphere.shopsphere.dto.UserResponseDto;
import com.shopsphere.shopsphere.entity.User;
import com.shopsphere.shopsphere.repository.UserRepository;
import com.shopsphere.shopsphere.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        User savedUser = userRepository.save(user);

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> new UserResponseDto(
                        u.getId(),
                        u.getName(),
                        u.getEmail()
                ))
                .toList();
    }
}
