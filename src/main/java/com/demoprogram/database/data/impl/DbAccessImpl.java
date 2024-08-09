package com.demoprogram.database.data.impl;

import com.demoprogram.database.data.DbAccess;
import com.demoprogram.database.model.DbMapper;
import com.demoprogram.database.model.JobCardModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DbAccessImpl implements DbAccess {

//    private final JobCardModel jobCardModel;

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate restTemplate;

//    public DbAccessImpl(JobCardModel jobCardModel) {
//        this.jobCardModel = jobCardModel;
//    }

    @Override
    public JobCardModel getById(Integer id) {
        List<JobCardModel> res = restTemplate.query("SELECT * FROM JOBCARD WHERE ID =?", new DbMapper(),id);
        if(!res.isEmpty()) {
            return res.get(0);
        }
        else{
            return null;
        }
    }

    @Override
    public List<JobCardModel> getAll() {
        List<JobCardModel> res = restTemplate.query("SELECT * FROM JOBCARD", new DbMapper());
        return res;
    }

    @Override
    public List<JobCardModel> searchByCustName(String s){
        List<JobCardModel> res = restTemplate.query("SELECT * FROM JOBCARD WHERE CUSTNAME LIKE ?", new DbMapper(),"%"+s+"%");
        return  res;
    }

    @Override
    public JobCardModel save(JobCardModel jobCardModel) {
        int res1 = restTemplate.update("INSERT INTO JOBCARD(DATE, JOBCARDNO, WORKASSIGNED, CUSTNAME, CUSTNO, CUSTADDRESS, PINCODE, VEHMODEL, VEH_REG_NO, CUSTVOICE, STATUS) VALUES(?,?,?,?,?,?,?,?,?,?,?)",
                jobCardModel.getDate(), jobCardModel.getJobCardNo(),
                jobCardModel.getWorkAssigned(), jobCardModel.getCustName(),
                jobCardModel.getCustNo(), jobCardModel.getCustAddress(), jobCardModel.getPinCode(),
                jobCardModel.getVehModel(), jobCardModel.getVeh_reg_no(), jobCardModel.getCustVoice(), jobCardModel.getStatus());
        if(res1>0){
            return jobCardModel;
        }else{
            return null;
        }
    }

    @Override
    public JobCardModel update(JobCardModel jobCardModel, Integer id){
        int res = restTemplate.update("UPDATE JOBCARD SET DATE=?, JOBCARDNO=?, WORKASSIGNED=?, CUSTNAME=?, CUSTNO=?, CUSTADDRESS=?, PINCODE=?, VEHMODEL=?, VEH_REG_NO=?, CUSTVOICE=?, STATUS=? WHERE ID=?",
                jobCardModel.getDate(), jobCardModel.getJobCardNo(),
                jobCardModel.getWorkAssigned(), jobCardModel.getCustName(),
                jobCardModel.getCustNo(), jobCardModel.getCustAddress(), jobCardModel.getPinCode(),
                jobCardModel.getVehModel(), jobCardModel.getVeh_reg_no(), jobCardModel.getCustVoice(), jobCardModel.getStatus(),id);
        if(res>0){
            return jobCardModel;
        }
        else
        {
            return null;
        }
    }

    @Override
    public int deleteById(Integer id) {
        int res = restTemplate.update("DELETE FROM JOBCARD WHERE ID = ?",id);
        return res;
}
}
