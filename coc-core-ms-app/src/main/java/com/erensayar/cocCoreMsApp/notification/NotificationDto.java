package com.erensayar.cocCoreMsApp.notification;

import com.erensayar.cocCoreMsApp.campaign.CampaignDto;
import com.erensayar.cocCoreMsApp.user.UserDto;
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
public class NotificationDto {
  private List<UserDto> users;
  private CampaignDto campaign;
}
