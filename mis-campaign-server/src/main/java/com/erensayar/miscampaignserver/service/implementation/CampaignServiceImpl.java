package com.erensayar.miscampaignserver.service.implementation;

import com.erensayar.coscommonobject.httpStatus.Status_204;
import com.erensayar.coscommonobject.httpStatus.Status_400;
import com.erensayar.miscampaignserver.entity.Campaign;
import com.erensayar.miscampaignserver.entity.dto.internal.CampaignDto;
import com.erensayar.miscampaignserver.repository.CampaignRepository;
import com.erensayar.miscampaignserver.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    @Override
    public List<Campaign> getCampaigns() {
        List<Campaign> campaigns = campaignRepository.findAll();
        if (campaigns.isEmpty()) {
            throw new Status_204();
        } else {
            return campaigns;
        }
    }

    @Override
    public Campaign getCampaignById(Long id) {
        Optional<Campaign> optCampaign = campaignRepository.findById(id);
        if (optCampaign.isPresent()) {
            return optCampaign.get();
        } else {
            throw new Status_204();
        }
    }

    @Override
    public Campaign createCampaign(CampaignDto campaignDto) {
        if (campaignDto.getId() != null) {
            throw new Status_400();
        }
        return campaignRepository.save(converter(campaignDto));
    }

    @Override
    public Campaign updateCampaign(CampaignDto campaignDto) {
        if (campaignDto.getId() == null) {
            throw new Status_400();
        }
        if (campaignRepository.findById(campaignDto.getId()).isPresent()) {
            return campaignRepository.save(converter(campaignDto));
        } else {
            throw new Status_204();
        }
    }

    @Override
    public void deleteCampaignById(Long id) {
        if (campaignRepository.findById(id).isPresent()) {
            campaignRepository.deleteById(id);
        } else {
            throw new Status_204();
        }
    }

    /**
     * This is necessary because we cant create or update with original object, directly.
     * We need take dto then create real object. Otherwise it can cause be vulnerability.
     */
    private Campaign converter(CampaignDto campaignDto) {
        return Campaign.builder()
                .id(campaignDto.getId())
                .description(campaignDto.getDescription())
                .isGeneral(campaignDto.getIsGeneral())
                .name(campaignDto.getName())
                .products(campaignDto.getProducts())
                .build();
    }
}
