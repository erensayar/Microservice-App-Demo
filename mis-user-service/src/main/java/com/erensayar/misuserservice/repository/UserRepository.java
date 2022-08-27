package com.erensayar.misuserservice.repository;

import com.erensayar.misuserservice.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findAllByProductIdIn(List<Long> prodIdList);

}
