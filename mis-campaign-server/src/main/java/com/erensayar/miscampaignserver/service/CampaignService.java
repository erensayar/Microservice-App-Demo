package com.erensayar.miscampaignserver.service;

import com.erensayar.miscampaignserver.entity.Campaign;
import com.erensayar.miscampaignserver.entity.dto.internal.CampaignDto;

import java.util.List;

public interface CampaignService {

    List<Campaign> getCampaigns();

    Campaign getCampaignById(Long id);

    Campaign createCampaign(CampaignDto campaignDto);

    Campaign updateCampaign(CampaignDto campaignDto);

    void deleteCampaignById(Long id);

}
