package com.demoprogram.database.data;

import com.demoprogram.database.model.JobCardModel;

import java.util.*;

public interface DbAccess {
    public JobCardModel getById(Integer id);
    public List<JobCardModel> getAll();
    public JobCardModel save(JobCardModel jobCard1);
    public int deleteById(Integer id);
    public JobCardModel update(JobCardModel jobCardModel, Integer id);
    public List<JobCardModel> searchByCustName(String s);
}
