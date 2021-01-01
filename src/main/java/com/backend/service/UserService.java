package com.backend.service;

import com.backend.dao.User;
import com.backend.dto.UserDto;
import com.backend.dto.UserResponseDto;
import com.backend.repository.UserRepository;
import com.backend.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String saveUser(UserDto userDto){
        return userRepository.save(userDto.toEntity()).getId();
    }

    @Transactional
    public UserResponseDto findById (String id) {
        User entity = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(id + " Not Found"));
        return new UserResponseDto(entity);
    }

    @Transactional
    public String update (String id, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(id + " Not Found"));

        user.update(requestDto.getPhone(), requestDto.getName(), requestDto.getProfile_image(),
                requestDto.getBackground_image(), requestDto.getStatus_msg());
        return "ID " + id + " Update Complete";
    }

    @Transactional
    public String delete (String id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(id + " Not Found"));

        userRepository.delete(user);
        return id + " Deletion Completed";
    }
}
