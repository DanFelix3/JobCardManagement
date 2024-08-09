package com.demoprogram.database.config;

import com.demoprogram.database.model.JobCardModel;
import com.demoprogram.database.services.JobCardServices;
import com.demoprogram.database.services.impl.JobCardServicesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Configuration
public class configuration {

    @Bean(name="jobCardServices")
    @RequestScope
    public JobCardServices getJobCardServices(){
        return new JobCardServicesImpl();
    }
}
