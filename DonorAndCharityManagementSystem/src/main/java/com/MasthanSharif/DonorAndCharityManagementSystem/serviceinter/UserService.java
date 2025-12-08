package com.MasthanSharif.DonorAndCharityManagementSystem.serviceinter;

import com.MasthanSharif.DonorAndCharityManagementSystem.requestdto.UserRequestDto;
import com.MasthanSharif.DonorAndCharityManagementSystem.responsedto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto dto);
    UserResponseDto getUserById(Long userId);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(Long userId, UserRequestDto dto);
    void deleteUser(Long userId);
}
