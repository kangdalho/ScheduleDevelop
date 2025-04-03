package com.example.scheduledevelop.dto;


import com.example.scheduledevelop.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String userName;

    private final String email;

    public UserResponseDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public static UserResponseDto toDto(User user){
        return new UserResponseDto(user.getUserName(),user.getEmail());
    }

}
