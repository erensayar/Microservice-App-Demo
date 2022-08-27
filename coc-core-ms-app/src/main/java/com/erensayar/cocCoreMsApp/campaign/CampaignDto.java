package com.erensayar.cocCoreMsApp.campaign;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampaignDto {
  private Long id;
  private String name;
  private LocalDate startDate;
  private LocalDate dueDate;
  private String description;
  private List<Long> productIdList;
}
