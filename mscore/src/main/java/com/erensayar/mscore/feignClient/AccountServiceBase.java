package com.erensayar.mscore.feignClient;

import com.erensayar.mscore.account.AccountDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AccountServiceBase {

    @GetMapping(value = "/api/v1/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<AccountDto>> getAccounts();

    @PostMapping(value = "/api/v1/accounts/getAccountsByProductIdList", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<AccountDto>> getAccountsByProductIdList(@RequestBody List<Long> prodIdList);

    @GetMapping(value = "/api/v1/accounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id);

    @PostMapping(value = "/api/v1/accounts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto);

    @PutMapping(value = "/api/v1/accounts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDto);

    @DeleteMapping(value = "/api/v1/accounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> deleteAccountById(@PathVariable("id") Long id);

}
