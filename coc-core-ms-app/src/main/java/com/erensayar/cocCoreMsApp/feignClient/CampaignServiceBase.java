package com.erensayar.cocCoreMsApp.feignClient;

import com.erensayar.cocCoreMsApp.campaign.CampaignDto;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CampaignServiceBase {

  @GetMapping(value = "/api/v1/campaigns", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<CampaignDto>> getCampaigns();

  @GetMapping(value = "/api/v1/campaigns/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<CampaignDto> getCampaignById(@PathVariable("id") Long id);

  @PostMapping(value = "/api/v1/campaigns", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto campaign);

  @PutMapping(value = "/api/v1/campaigns", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<CampaignDto> updateCampaign(@RequestBody CampaignDto updatedCampaign);


  @DeleteMapping(value = "/api/v1/campaigns/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<String> deleteCampaignById(@PathVariable("id") Long id);


}
