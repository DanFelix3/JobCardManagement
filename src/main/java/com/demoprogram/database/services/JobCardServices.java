package com.demoprogram.database.services;

import com.demoprogram.database.model.JobCardModel;

import java.util.List;

public interface JobCardServices {

    public JobCardModel getById(Integer id);
    public List<JobCardModel> findAll();
    public JobCardModel add(JobCardModel jobCardModel);
    public JobCardModel update(JobCardModel jobCardModel, Integer id);
    public boolean deleteById(Integer id);
    public List<JobCardModel> searchByCustName(String s);

}
