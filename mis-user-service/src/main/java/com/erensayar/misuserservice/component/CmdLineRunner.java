package com.erensayar.misuserservice.component;

import com.erensayar.misuserservice.entity.User;
import com.erensayar.misuserservice.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CmdLineRunner implements CommandLineRunner {

  private final UserRepository userRepository;

  @Override
  public void run(String... args) {

    User user1 = userRepository.save(User.builder()
        .id(1L)
        .name("user-1-name")
        .surname("user-1-surname")
        .email("user1@mail.com")
        .phone("+905552223344")
        .productId(List.of(1L, 2L, 3L))
        .build());

    User user2 = userRepository.save(User.builder()
        .id(2L)
        .name("user-2-name")
        .surname("user-2-surname")
        .email("user2@mail.com")
        .phone("+905552223344")
        .productId(List.of(1L, 3L))
        .build());

    User user3 = userRepository.save(User.builder()
        .id(3L)
        .name("user-3-name")
        .surname("user-3-surname")
        .email("user4@mail.com")
        .phone("+905552223344")
        .productId(List.of(1L, 2L, 3L, 4L, 5L))
        .build());

    User user4 = userRepository.save(User.builder()
        .id(4L)
        .name("user-4-name")
        .surname("user-4-surname")
        .email("user4@mail.com")
        .phone("+905552223344")
        .productId(List.of(1L, 2L, 3L, 4L))
        .build());

    User user5 = userRepository.save(User.builder()
        .id(5L)
        .name("user-5-name")
        .surname("user-5-surname")
        .email("user5@mail.com")
        .phone("+905552223344")
        .productId(List.of(5L))
        .build());
  }

}
