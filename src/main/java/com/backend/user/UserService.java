package com.backend.user;

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
                new IllegalArgumentException("ID : " + id + "인 회원정보가 없습니다."));

        return new UserResponseDto(entity);
    }
}
