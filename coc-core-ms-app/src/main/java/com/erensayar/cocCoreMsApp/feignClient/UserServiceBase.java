package com.erensayar.cocCoreMsApp.feignClient;

import com.erensayar.cocCoreMsApp.user.UserDto;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserServiceBase {

  @GetMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<UserDto>> getUsers();

  @PostMapping(value = "/api/v1/users/getUsersByProductIdList", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<UserDto>> getUsersByProductIdList(@RequestBody List<Long> prodIdList);

  @GetMapping(value = "/api/v1/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id);

  @PostMapping(value = "/api/v1/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto);

  @PutMapping(value = "/api/v1/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto);

  @DeleteMapping(value = "/api/v1/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<String> deleteUserById(@PathVariable("id") Long id);

}
