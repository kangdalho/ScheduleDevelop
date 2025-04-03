package com.example.scheduledevelop.UserService;


import com.example.scheduledevelop.UserRepository.UserRepository;
import com.example.scheduledevelop.dto.SignUpResponseDto;
import com.example.scheduledevelop.dto.UserResponseDto;
import com.example.scheduledevelop.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String userName, String email, String password){


        User user = new User(userName,email,password);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(),savedUser.getUserName(),savedUser.getEmail());
    }

    public UserResponseDto findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        //NPE 방지
        if (optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist id = " + id);
        }
        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUserName(), findUser.getEmail());
    }

    @Transactional
    public void updatePassword(Long id,String oldPassword, String newPassword) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        if(!findUser.getPassword().equals(oldPassword)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"비밀번호가 일치하지 않습니다.");
        }

        findUser.updatePassword(newPassword);

    }

    public void delete(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);

    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::toDto)
                .toList();

    }
}
