package com.shopsphere.shopsphere.controller;

import com.shopsphere.shopsphere.dto.UserRequestDto;
import com.shopsphere.shopsphere.dto.UserResponseDto;
import com.shopsphere.shopsphere.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDto createUser(
            @Valid @RequestBody UserRequestDto dto) {
        return userService.createUser(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }
}


