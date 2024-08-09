//package com.demoprogram.database.controller;
//
//import com.demoprogram.database.model.JobCardModel;
//import com.demoprogram.database.services.JobCardServices;
//import groovy.transform.AnnotationCollector;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/jobcards")
//public class DisplayController {
//    @Autowired
//    JobCardServices jobCardServices;
//
//    @GetMapping("/listAll")
//    public String getAllJobCards(Model model){
//        List<JobCardModel> jobcards = jobCardServices.findAll();
//        model.addAttribute("title","Job Cards");
//        model.addAttribute("jobcards",jobcards);
//        return "listAll.html";
//    }
//
//
//}
