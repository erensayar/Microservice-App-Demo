package com.erensayar.cocCoreMsApp.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MIS-CAMPAIGN-SERVICE", contextId = "CampaignServiceFeignClient")
public interface CampaignServiceFeignClient extends CampaignServiceBase {

}
