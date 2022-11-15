package com.erensayar.misaccountservice.component;

import com.erensayar.misaccountservice.entity.Account;
import com.erensayar.misaccountservice.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CmdLineRunner implements CommandLineRunner {

  private final AccountRepository accountRepository;

  @Override
  public void run(String... args) {

    Account account1 = accountRepository.save(Account.builder()
            .id(1L)
            .name("account-1-name")
            .surname("account-1-surname")
            .email("account1@mail.com")
            .phone("+905552223344")
            .productId(List.of(1L, 2L, 3L))
            .build());

    Account account2 = accountRepository.save(Account.builder()
            .id(2L)
            .name("account-2-name")
            .surname("account-2-surname")
            .email("account2@mail.com")
            .phone("+905552223344")
            .productId(List.of(1L, 3L))
            .build());

    Account account3 = accountRepository.save(Account.builder()
            .id(3L)
            .name("account-3-name")
            .surname("account-3-surname")
            .email("account4@mail.com")
            .phone("+905552223344")
            .productId(List.of(1L, 2L, 3L, 4L, 5L))
            .build());

    Account account4 = accountRepository.save(Account.builder()
            .id(4L)
            .name("account-4-name")
            .surname("account-4-surname")
            .email("account4@mail.com")
            .phone("+905552223344")
            .productId(List.of(1L, 2L, 3L, 4L))
            .build());

    Account account5 = accountRepository.save(Account.builder()
            .id(5L)
            .name("account-5-name")
            .surname("account-5-surname")
            .email("account5@mail.com")
            .phone("+905552223344")
            .productId(List.of(5L))
            .build());
  }

}
