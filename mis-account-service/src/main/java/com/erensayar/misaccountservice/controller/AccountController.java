package com.erensayar.misaccountservice.controller;

import com.erensayar.mscore.feignClient.AccountServiceBase;
import com.erensayar.mscore.account.AccountDto;
import com.erensayar.misaccountservice.service.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AccountController implements AccountServiceBase {

  private final AccountService accountService;

  @Override
  public ResponseEntity<List<AccountDto>> getAccounts() {
    return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<AccountDto>> getAccountsByProductIdList(@RequestBody List<Long> prodIdList) {
    return new ResponseEntity<>(accountService.getAccountsByProductIdList(prodIdList), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
    return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDto) {
    return new ResponseEntity<>(accountService.updateAccount(accountDto), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<String> deleteAccountById(@PathVariable("id") Long id) {
    accountService.deleteAccountById(id);
    return ResponseEntity.ok(null);
  }
}
