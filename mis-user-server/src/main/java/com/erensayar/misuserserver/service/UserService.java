package com.erensayar.misuserserver.service;

import com.erensayar.misuserserver.entity.User;
import com.erensayar.misuserserver.entity.dto.UserDto;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(Long id);

    User createUser(UserDto userDto);

    User updateUser(UserDto userDto);

    void deleteUserById(Long id);

}
