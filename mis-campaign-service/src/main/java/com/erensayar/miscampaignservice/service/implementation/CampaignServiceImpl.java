package com.erensayar.miscampaignservice.service.implementation;

import com.erensayar.cocCoreMsApp.campaign.CampaignDto;
import com.erensayar.cocCoreMsApp.feignClient.UserServiceFeignClient;
import com.erensayar.cocCoreMsApp.notification.NotificationDto;
import com.erensayar.cocCoreMsApp.user.UserDto;
import com.erensayar.core.error.exception.BadRequestException;
import com.erensayar.core.error.exception.NoContentException;
import com.erensayar.miscampaignservice.entity.Campaign;
import com.erensayar.miscampaignservice.repository.CampaignRepository;
import com.erensayar.miscampaignservice.service.CampaignNotificationService;
import com.erensayar.miscampaignservice.service.CampaignService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CampaignServiceImpl implements CampaignService {

  private final CampaignRepository campaignRepository;
  private final ModelMapper modelMapper;
  private final UserServiceFeignClient userServiceFeignClient;
  private final CampaignNotificationService campaignNotificationService;

  @Override
  public List<CampaignDto> getCampaigns() {
    List<Campaign> campaignList = campaignRepository.findAll();
    return campaignList
        .stream()
        .map(element -> modelMapper.map(element, CampaignDto.class))
        .collect(Collectors.toList());
  }

  @Override
  public CampaignDto getCampaignById(Long id) {
    return modelMapper.map(campaignRepository.findById(id).orElseThrow(NoContentException::new), CampaignDto.class);
  }

  @Override
  public CampaignDto createCampaign(CampaignDto campaignDto) {
    if (campaignDto.getId() != null) {
      throw new BadRequestException();
    }
    CampaignDto savedCampaignDto = saveCampaign(campaignDto);
    pushNotification(campaignDto);
    return savedCampaignDto;
  }

  private void pushNotification(CampaignDto campaignDto) {
    // Get Users By Product
    List<UserDto> user = userServiceFeignClient.getUsersByProductIdList(campaignDto.getProductIdList()).getBody();
    // Build NotificationDto And Push Notification
    campaignNotificationService.pushCampaignNotification(NotificationDto.builder()
        .campaign(campaignDto)
        .users(user)
        .build());
  }

  private CampaignDto saveCampaign(CampaignDto campaignDto) {
    Campaign campaign = modelMapper.map(campaignDto, Campaign.class);
    Campaign savedCampaign = campaignRepository.save(campaign);
    return modelMapper.map(savedCampaign, CampaignDto.class);
  }

  @Override
  public CampaignDto updateCampaign(CampaignDto campaignDto) {
    campaignRepository.findById(campaignDto.getId()).orElseThrow(BadRequestException::new);
    return saveCampaign(campaignDto);
  }

  @Override
  public void deleteCampaignById(Long id) {
    if (campaignRepository.findById(id).isEmpty()) {
      throw new BadRequestException();
    }
    campaignRepository.deleteById(id);
  }

}
