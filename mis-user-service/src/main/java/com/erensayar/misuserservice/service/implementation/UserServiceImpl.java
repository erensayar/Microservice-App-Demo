package com.erensayar.misuserservice.service.implementation;

import com.erensayar.coccoremsapp.user.UserDto;
import com.erensayar.core.error.exception.BadRequestException;
import com.erensayar.core.error.exception.NoContentException;
import com.erensayar.misuserservice.entity.User;
import com.erensayar.misuserservice.repository.UserRepository;
import com.erensayar.misuserservice.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Override
  public List<UserDto> getUsers() {
    List<User> userList = userRepository.findAll();
    return userList
        .stream()
        .map(element -> modelMapper.map(element, UserDto.class))
        .collect(Collectors.toList());
  }

  @Override
  public List<UserDto> getUsersByProductIdList(List<Long> prodIdList) {
    List<User> userList = userRepository.findAllByProductIdIn(prodIdList);
    Set<User> userListSet = new HashSet<>(userList);
    return userListSet
        .stream()
        .map(element -> modelMapper.map(element, UserDto.class))
        .collect(Collectors.toList());
  }

  @Override
  public UserDto getUserById(Long id) {
    User user = userRepository.findById(id).orElseThrow(NoContentException::new);
    return modelMapper.map(user, UserDto.class);
  }

  @Override
  public UserDto createUser(UserDto userDto) {
    if (userDto.getId() != null) {
      throw new BadRequestException();
    }
    return saveUser(userDto);
  }

  private UserDto saveUser(UserDto userDto) {
    User user = modelMapper.map(userDto, User.class);
    User savedUser = userRepository.save(user);
    return modelMapper.map(savedUser, UserDto.class);
  }

  @Override
  public UserDto updateUser(UserDto userDto) {
    userRepository.findById(userDto.getId()).orElseThrow(BadRequestException::new);
    return saveUser(userDto);
  }

  @Override
  public void deleteUserById(Long id) {
    userRepository.findById(id).orElseThrow(BadRequestException::new);
    userRepository.deleteById(id);
  }

}
