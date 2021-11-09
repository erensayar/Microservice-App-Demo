package com.erensayar.misuserserver.service.implementation;

import com.erensayar.coscommonobject.httpStatus.Status_204;
import com.erensayar.coscommonobject.httpStatus.Status_400;
import com.erensayar.misuserserver.entity.User;
import com.erensayar.misuserserver.entity.dto.UserDto;
import com.erensayar.misuserserver.repository.UserRepository;
import com.erensayar.misuserserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new Status_204();
        } else {
            return users;
        }
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(Status_204::new);
    }

    @Override
    public User createUser(UserDto userDto) {
        if (userDto.getId() != null) {
            throw new Status_400();
        }
        return userRepository.save(converter(userDto));
    }

    @Override
    public User updateUser(UserDto userDto) {
        if (userDto.getId() == null) {
            throw new Status_400();
        }
        if (userRepository.findById(userDto.getId()).isPresent()) {
            return userRepository.save(converter(userDto));
        } else {
            throw new Status_204();
        }
    }

    @Override
    public void deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new Status_204();
        }
    }

    private User converter(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .email(userDto.getEmail())
                .products(userDto.getProducts())
                .build();
    }
}
