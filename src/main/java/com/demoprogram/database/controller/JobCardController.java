package com.demoprogram.database.controller;

import com.demoprogram.database.model.JobCardModel;
import com.demoprogram.database.services.JobCardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class JobCardController {

    @Autowired
    JobCardServices services;

    @GetMapping("/all")
    public List<JobCardModel> findAll(){
        return services.findAll();
    }

    @GetMapping("/{id}")
    public JobCardModel getById(@PathVariable Integer id){
        return services.getById(id);
    }

    @GetMapping("/search/{s}")
    public List<JobCardModel> searchByCardNo(@PathVariable String s){
        return services.searchByCustName(s);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/add")
    public JobCardModel add(@RequestBody JobCardModel jobCardModel){
        return services.add(jobCardModel);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/del/{id}")
    public String delete(@PathVariable Integer id){
        boolean res = services.deleteById(id);
        if(res){
            return "Deleted Successfully";}
        else{
            return "Not Deleted";
        }
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/upd/{id}")
    public JobCardModel update(@RequestBody JobCardModel jobCardModel,@PathVariable Integer id){
        return services.update(jobCardModel,id);
    }

}
