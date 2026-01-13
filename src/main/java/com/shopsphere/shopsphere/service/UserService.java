package com.shopsphere.shopsphere.service;

import com.shopsphere.shopsphere.dto.UserRequestDto;
import com.shopsphere.shopsphere.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto dto);

    List<UserResponseDto> getAllUsers();
}
