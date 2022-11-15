package com.erensayar.misaccountservice.repository;

import com.erensayar.misaccountservice.entity.Account;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

  List<Account> findAllByProductIdIn(List<Long> prodIdList);

}
