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
}
