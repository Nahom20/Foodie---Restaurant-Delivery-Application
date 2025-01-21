package com.foodie.userinfo.Service;

import com.foodie.userinfo.Dto.UserDto;
import com.foodie.userinfo.Entity.User;
import com.foodie.userinfo.Mapper.UserMapper;
import com.foodie.userinfo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserDto addUser(UserDto userDto) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserdtoToUser(userDto));
        return UserMapper.INSTANCE.mapUserToUserDto(savedUser);
    }

    public ResponseEntity<UserDto> fetchUserById(Integer userid) {

        Optional<User> user = userRepo.findById(userid);

        if(user.isPresent()){
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDto(user.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
