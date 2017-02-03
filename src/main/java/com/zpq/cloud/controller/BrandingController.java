package com.zpq.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zpq.cloud.dao.BrandingDao;
import com.zpq.cloud.model.Branding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/branding")
public class BrandingController {

    @Autowired
    private BrandingDao brandingDao;

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/getBrandings/all")
    public List<Branding> getAll(){
        return brandingDao.getAllBrandings();
    }

    @GetMapping("/getBrandings/domain/{domain}")
    public Branding getBrandingByDomain(@PathVariable String domain){
        return brandingDao.getBrandingByDomain(domain);
    }

    @GetMapping("/getBrandings/businessId/{businessId}")
    public Branding getBrandingByBusinessId(@PathVariable long businessId){
        return brandingDao.getBrandingByBusinessId(businessId);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-BRANDING-PROVIDER", false);
        return instance.getHomePageUrl();
    }

}
