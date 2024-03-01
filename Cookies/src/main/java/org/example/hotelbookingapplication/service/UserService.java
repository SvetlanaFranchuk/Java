package org.example.hotelbookingapplication.service;

import org.example.hotelbookingapplication.dao.user.UserDao;
import org.example.hotelbookingapplication.dto.user.UserResponseDto;
import org.example.hotelbookingapplication.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

private final UserDao userDao;
private final UserMapper userMapper;

   @Autowired
   public UserService(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

   public UserResponseDto getUser(long id){
       return userMapper.toUserResponseDto(userDao.read(id));
   }
}
