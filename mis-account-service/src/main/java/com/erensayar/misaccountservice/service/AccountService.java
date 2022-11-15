package com.erensayar.misaccountservice.service;

import com.erensayar.mscore.account.AccountDto;
import java.util.List;

public interface AccountService {

  List<AccountDto> getAccounts();

  List<AccountDto> getAccountsByProductIdList(List<Long> prodIdList);

  AccountDto getAccountById(Long id);

  AccountDto createAccount(AccountDto accountDto);

  AccountDto updateAccount(AccountDto accountDto);

  void deleteAccountById(Long id);

}
