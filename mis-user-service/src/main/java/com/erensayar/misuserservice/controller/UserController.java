package com.erensayar.misuserservice.controller;

import com.erensayar.coccoremsapp.feignClient.UserServiceBase;
import com.erensayar.coccoremsapp.user.UserDto;
import com.erensayar.misuserservice.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController implements UserServiceBase {

  private final UserService userService;

  @Override
  public ResponseEntity<List<UserDto>> getUsers() {
    return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<UserDto>> getUsersByProductIdList(@RequestBody List<Long> prodIdList) {
    return new ResponseEntity<>(userService.getUsersByProductIdList(prodIdList), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
    return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
    return new ResponseEntity<>(userService.updateUser(userDto), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
    userService.deleteUserById(id);
    return ResponseEntity.ok(null);
  }
}
