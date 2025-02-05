package com.foodie.userinfo.Controller;

import com.foodie.userinfo.Dto.UserDto;
import com.foodie.userinfo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "k8s-default-awsingre-9aa4c55379-1606959407.eu-west-2.elb.amazonaws.com")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto davedUser = userService.addUser(userDto);
        return new ResponseEntity<>(davedUser, HttpStatus.CREATED);
    }

    @GetMapping("{userid}")
    public ResponseEntity<UserDto> fetchUserById(@PathVariable Integer userid){
        return userService.fetchUserById(userid);
    }
}
