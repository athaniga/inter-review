package com.interreview.controllers;

import com.interreview.data.InterviewRepository;
import com.interreview.models.Account;
import com.interreview.models.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/create-listing")
public class InterviewListingController {

    private InterviewRepository interviewRepo;

    @Autowired
    public InterviewListingController(InterviewRepository interviewRepo) {
        this.interviewRepo = interviewRepo;
    }

    @GetMapping
    public String showCreateInterviewListing(Model model) {
        model.addAttribute("interview", new Interview());
        return "create-interview-listing";
    }

    @PostMapping
    public String handleCreateInterviewForm(@Valid @ModelAttribute("interview") Interview interview, Errors errors) {
        if (errors.hasErrors()) {
            return "create-interview-listing";
        }
        this.interviewRepo.save(interview);
        return "redirect:/reviews";
    }
}
