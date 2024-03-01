package org.example.hotelbookingapplication.service;

import org.example.hotelbookingapplication.dto.user.UserResponseDto;
import org.example.hotelbookingapplication.mapper.UserMapper;
import org.example.hotelbookingapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

private final UserRepository userRepository;
private final UserMapper userMapper;
   //TODO - не используется в рамках данного задания, доработать при расширении ТЗ
   @Autowired
   public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

   public UserResponseDto getUser(long id){
       return userMapper.toUserResponseDto(userRepository.getReferenceById(id));
   }
}
