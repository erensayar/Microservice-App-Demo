package com.erensayar.misaccountservice.service.implementation;

import com.erensayar.misaccountservice.entity.Account;
import com.erensayar.mscore.account.AccountDto;
import com.erensayar.core.error.exception.BadRequestException;
import com.erensayar.core.error.exception.NoContentException;
import com.erensayar.misaccountservice.repository.AccountRepository;
import com.erensayar.misaccountservice.service.AccountService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;
  private final ModelMapper modelMapper;

  @Override
  public List<AccountDto> getAccounts() {
    List<Account> accountList = accountRepository.findAll();
    return accountList
            .stream()
            .map(element -> modelMapper.map(element, AccountDto.class))
            .collect(Collectors.toList());
  }

  @Override
  public List<AccountDto> getAccountsByProductIdList(List<Long> prodIdList) {
    List<Account> accountList = accountRepository.findAllByProductIdIn(prodIdList);
    Set<Account> accountListSet = new HashSet<>(accountList);
    return accountListSet
            .stream()
            .map(element -> modelMapper.map(element, AccountDto.class))
            .collect(Collectors.toList());
  }

  @Override
  public AccountDto getAccountById(Long id) {
    Account account = accountRepository.findById(id).orElseThrow(NoContentException::new);
    return modelMapper.map(account, AccountDto.class);
  }

  @Override
  public AccountDto createAccount(AccountDto accountDto) {
    if (accountDto.getId() != null) {
      throw new BadRequestException();
    }
    return saveAccount(accountDto);
  }

  private AccountDto saveAccount(AccountDto accountDto) {
    Account account = modelMapper.map(accountDto, Account.class);
    Account savedAccount = accountRepository.save(account);
    return modelMapper.map(savedAccount, AccountDto.class);
  }

  @Override
  public AccountDto updateAccount(AccountDto accountDto) {
    accountRepository.findById(accountDto.getId()).orElseThrow(BadRequestException::new);
    return saveAccount(accountDto);
  }

  @Override
  public void deleteAccountById(Long id) {
    accountRepository.findById(id).orElseThrow(BadRequestException::new);
    accountRepository.deleteById(id);
  }

}
