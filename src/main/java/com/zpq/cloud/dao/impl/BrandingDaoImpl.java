package com.zpq.cloud.dao.impl;


import com.zpq.cloud.dao.BrandingDao;
import com.zpq.cloud.model.Branding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BrandingDaoImpl implements BrandingDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Branding> getAllBrandings() {
        String sql = "select * from Branding";
        List<Branding> brandings = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Branding.class));

        return brandings;
    }

    @Override
    public Branding getBrandingByDomain(String domain) {
        String sql = "select * from Branding where domain = ?";
        Branding branding = (Branding)jdbcTemplate.queryForObject(
                sql, new Object[]{domain},
                new BeanPropertyRowMapper(Branding.class));

        return branding;
    }

    @Override
    public Branding getBrandingByBusinessId(long businessId) {
        String sql = "SELECT br.* FROM BusinessBranding bb JOIN Branding br ON bb.BrandingID = br.ID WHERE bb.BusinessID = ?";
        Branding branding = (Branding)jdbcTemplate.queryForObject(
                sql, new Object[]{businessId},
                new BeanPropertyRowMapper(Branding.class));

        return branding;
    }


}


