package com.erensayar.misuserservice.service;

import com.erensayar.cocCoreMsApp.user.UserDto;
import java.util.List;

public interface UserService {

  List<UserDto> getUsers();

  List<UserDto> getUsersByProductIdList(List<Long> prodIdList);

  UserDto getUserById(Long id);

  UserDto createUser(UserDto userDto);

  UserDto updateUser(UserDto userDto);

  void deleteUserById(Long id);

}
