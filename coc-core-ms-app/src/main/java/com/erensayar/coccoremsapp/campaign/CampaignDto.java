package com.erensayar.coccoremsapp.campaign;

import java.io.Serializable;
import java.time.LocalDate;
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
public class CampaignDto implements Serializable {
  private Long id;
  private String name;
  private LocalDate startDate;
  private LocalDate dueDate;
  private String description;
  private List<Long> productIdList;
}
