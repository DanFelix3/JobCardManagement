package com.demoprogram.database.controller;

import com.demoprogram.database.model.JobCardModel;
import com.demoprogram.database.model.LoginModel;
import com.demoprogram.database.model.SearchModel;
import com.demoprogram.database.services.JobCardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/jobcards")
public class PageController {

    @Autowired
    JobCardServices jobCardServices;

    @GetMapping("/login")
    public String displayLoginPage(Model model){
        model.addAttribute("loginModel", new LoginModel());
        return "loginPage.html";
    }

    @PostMapping("/loginResult")
    public String displayResultPage(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginModel", loginModel);
            return "loginPage.html";
        }
        model.addAttribute("loginModel", loginModel);
        return "loginResult.html";
    }

    @GetMapping("/listAll")
    public String getAllJobCards(Model model){
        List<JobCardModel> jobcards = jobCardServices.findAll();
        model.addAttribute("title","Job Cards");
        model.addAttribute("jobcards",jobcards);
        return "listAll.html";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("jobcards", new JobCardModel());
        return "addNewJobCard.html";
    }

    @PostMapping("/createResult")
    public String showCreateResultPage(@Valid JobCardModel jobCardModel, BindingResult bindingResul, Model model){
        jobCardModel.setId(null);
        jobCardServices.add(jobCardModel);
        List<JobCardModel> jobcards = jobCardServices.findAll();
        model.addAttribute("title","Job Cards Updated");
        model.addAttribute("jobcards",jobcards);
        return "listAll.html";
    }

    @GetMapping("/search")
    public String showSearchPage(Model model){
        model.addAttribute("searches", new SearchModel());
        return "searchPage.html";
    }

    @PostMapping("/searchResult")
    public String showSearchResultPage(@Valid SearchModel searchModel, BindingResult bindingResul, Model model){
        List<JobCardModel> jobcards = jobCardServices.searchByCustName(searchModel.getSearchItem());
        model.addAttribute("jobcards",jobcards);
        return "listAll.html";
    }

    @GetMapping("/listAllForAdmin")
    public String getAllJobCardsForAdmin(Model model){
        List<JobCardModel> jobcards = jobCardServices.findAll();
        model.addAttribute("title","Job Cards Admin View");
        model.addAttribute("jobcards",jobcards);
        return "listAllForAdmin.html";
    }

    @PostMapping("/edit")
    public String getEditPage(JobCardModel jobCardModel, Model model){
        model.addAttribute("jobcards", jobCardModel);
        return "editPage.html";
    }

    @PostMapping("/updateResult")
    public String getEditResultPage(JobCardModel jobCardModel, Model model){
        jobCardServices.update(jobCardModel, jobCardModel.getId());
        List<JobCardModel> jobcards = jobCardServices.findAll();
        model.addAttribute("title","Job Cards Updated");
        model.addAttribute("jobcards",jobcards);
        return "listAllForAdmin.html";
    }

    @PostMapping("/delete")
    public String doDeleteAction(JobCardModel jobCardModel, Model model){
        jobCardServices.deleteById(jobCardModel.getId());
        List<JobCardModel> jobcards = jobCardServices.findAll();
        model.addAttribute("title","Job Cards Updated");
        model.addAttribute("jobcards",jobcards);
        return "listAllForAdmin.html";
    }

}
