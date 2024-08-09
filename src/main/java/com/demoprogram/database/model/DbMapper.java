package com.demoprogram.database.model;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DbMapper implements RowMapper<JobCardModel> {

    @Override
    public JobCardModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        JobCardModel jbm = new JobCardModel(rs.getInt("id"),rs.getDate("date"),
                rs.getString("jobcardno"), rs.getString("workassigned"),
                rs.getString("custname"), rs.getString("custno"),
                rs.getString("custaddress"), rs.getInt("pincode"),
                rs.getString("vehmodel"),rs.getString("veh_reg_no"),
                rs.getString("custvoice"), rs.getString("status"));
        return jbm;
    }
}
