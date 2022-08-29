package com.erensayar.miscampaignservice.service;

import com.erensayar.coccoremsapp.campaign.CampaignDto;
import java.util.List;

public interface CampaignService {

  List<CampaignDto> getCampaigns();

  CampaignDto getCampaignById(Long id);

  CampaignDto createCampaign(CampaignDto campaignDto);

  CampaignDto updateCampaign(CampaignDto campaignDto);

  void deleteCampaignById(Long id);

}
