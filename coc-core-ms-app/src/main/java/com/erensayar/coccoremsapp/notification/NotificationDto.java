package com.erensayar.coccoremsapp.notification;

import com.erensayar.coccoremsapp.campaign.CampaignDto;
import com.erensayar.coccoremsapp.user.UserDto;
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
  private List<UserDto> users;
  private CampaignDto campaign;
}
