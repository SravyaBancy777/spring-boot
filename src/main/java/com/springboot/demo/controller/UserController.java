package com.springboot.demo.controller;


import com.springboot.demo.model.UserResponseModel;
import com.springboot.demo.service.UserService;
import com.springboot.demo.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping()
    public ResponseEntity<List<UserResponseModel>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UserResponseModel> usersList = new ArrayList<>();
        users.stream().map(userDto -> modelMapper.map(userDto, UserResponseModel.class)).forEach((userResponseModel -> {
            usersList.add(userResponseModel);
        }));

        if(usersList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }


}
