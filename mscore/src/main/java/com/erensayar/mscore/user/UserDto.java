package com.erensayar.mscore.user;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDto implements Serializable {
  private Long id;
  private String name;
  private String surname;
  private String email;
  private String phone;
  private List<Long> productIdList;
}
