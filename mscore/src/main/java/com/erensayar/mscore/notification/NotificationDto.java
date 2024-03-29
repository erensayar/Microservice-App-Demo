package com.erensayar.mscore.notification;

import com.erensayar.mscore.campaign.CampaignDto;
import com.erensayar.mscore.account.AccountDto;
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
public class NotificationDto implements Serializable {
  private List<AccountDto> accounts;
  private CampaignDto campaign;
}
