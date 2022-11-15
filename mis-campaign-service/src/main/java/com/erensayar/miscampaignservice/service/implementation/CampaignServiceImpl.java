package com.erensayar.miscampaignservice.service.implementation;

import com.erensayar.miscampaignservice.service.StreamService;
import com.erensayar.mscore.campaign.CampaignDto;
import com.erensayar.mscore.feignClient.AccountServiceFeignClient;
import com.erensayar.mscore.notification.NotificationDto;
import com.erensayar.mscore.account.AccountDto;
import com.erensayar.core.error.exception.BadRequestException;
import com.erensayar.core.error.exception.NoContentException;
import com.erensayar.miscampaignservice.entity.Campaign;
import com.erensayar.miscampaignservice.repository.CampaignRepository;
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
  private final AccountServiceFeignClient accountServiceFeignClient;
  private final StreamService streamService;

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
    // Get Accounts By Product
    List<AccountDto> account = accountServiceFeignClient.getAccountsByProductIdList(campaignDto.getProductIdList()).getBody();
    // Build NotificationDto And Push Notification
    streamService.produce(NotificationDto.builder()
        .campaign(campaignDto)
        .accounts(account)
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
