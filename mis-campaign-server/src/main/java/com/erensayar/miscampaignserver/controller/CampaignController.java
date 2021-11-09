package com.erensayar.miscampaignserver.controller;

import com.erensayar.miscampaignserver.entity.dto.internal.CampaignDto;
import com.erensayar.miscampaignserver.service.CampaignService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "Campaign REST API Documentation")
@RequestMapping("/api/v1/campaigns")
@RequiredArgsConstructor
@RestController
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCampaigns() {
        return new ResponseEntity<>(campaignService.getCampaigns(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCampaignById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(campaignService.getCampaignById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCampaign(@RequestBody CampaignDto campaignDto) {
        return new ResponseEntity<>(campaignService.createCampaign(campaignDto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCampaign(@RequestBody CampaignDto updatedCampaign) {
        return new ResponseEntity<>(campaignService.updateCampaign(updatedCampaign), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCampaignById(@PathVariable("id") Long id) {
        campaignService.deleteCampaignById(id);
        return ResponseEntity.ok(null);
    }

}
