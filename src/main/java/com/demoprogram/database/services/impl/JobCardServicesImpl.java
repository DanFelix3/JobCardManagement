package com.demoprogram.database.services.impl;

import com.demoprogram.database.data.DbAccess;
import com.demoprogram.database.model.JobCardModel;
import com.demoprogram.database.services.JobCardServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobCardServicesImpl implements JobCardServices {

    @Autowired
    DbAccess dbAccess;

    @Override
    public List<JobCardModel> findAll(){
        return dbAccess.getAll();
    }

    @Override
    public JobCardModel add(JobCardModel jobCardModel){
        return dbAccess.save(jobCardModel);
    }

    @Override
    public JobCardModel getById(Integer id){
        return dbAccess.getById(id);
    }

    @Override
    public List<JobCardModel> searchByCustName(String s)
    {
        List<JobCardModel> res = dbAccess.searchByCustName(s);
        return res;
    }

    @Override
    public boolean deleteById(Integer id) {
        int res = dbAccess.deleteById(id);
        if(res>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public JobCardModel update(JobCardModel jobCardModel, Integer id){
        return dbAccess.update(jobCardModel,id);
    }
}
