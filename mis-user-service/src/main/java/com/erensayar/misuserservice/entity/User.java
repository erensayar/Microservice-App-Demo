package com.erensayar.misuserservice.entity;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "USERS")
@Entity
public class User {

  @Id
  private Long id;

  private String name;

  private String surname;

  private String email;

  private String phone;

  @ElementCollection
  @JoinTable(name = "RLT_USER_PRODUCT")
  private List<Long> productId;

}
