package com.erensayar.miscampaignservice.controller;

import com.erensayar.mscore.campaign.CampaignDto;
import com.erensayar.mscore.feignClient.CampaignServiceBase;
import com.erensayar.miscampaignservice.service.CampaignService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CampaignController implements CampaignServiceBase {

  private final CampaignService campaignService;

  @Override
  public ResponseEntity<List<CampaignDto>> getCampaigns() {
    return new ResponseEntity<>(campaignService.getCampaigns(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<CampaignDto> getCampaignById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(campaignService.getCampaignById(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto campaignDto) {
    return new ResponseEntity<>(campaignService.createCampaign(campaignDto), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<CampaignDto> updateCampaign(@RequestBody CampaignDto campaignDto) {
    return new ResponseEntity<>(campaignService.updateCampaign(campaignDto), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<String> deleteCampaignById(@PathVariable("id") Long id) {
    campaignService.deleteCampaignById(id);
    return ResponseEntity.ok(null);
  }

}
