package com.zpq.cloud.dao;


import com.zpq.cloud.model.Branding;

import java.util.List;

public interface BrandingDao {

    List<Branding> getAllBrandings();

    Branding getBrandingByDomain(String domain);

    Branding getBrandingByBusinessId(long businessId);
}
