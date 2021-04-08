package com.interreview.controllers;

import com.interreview.data.CareerFieldRepository;
import com.interreview.data.InterviewRepository;
import com.interreview.models.CareerField;
import com.interreview.models.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/create-listing")
public class ReviewController {

    private InterviewRepository interviewRepo;
    private CareerFieldRepository careerFieldRepo;

    @Autowired
    public ReviewController(InterviewRepository interviewRepo, CareerFieldRepository careerFieldRepo) {
        this.interviewRepo = interviewRepo;
        this.careerFieldRepo = careerFieldRepo;
    }

    @GetMapping
    public String showCreateInterviewListing(Model model) {
        List<CareerField> careerFields = (List<CareerField>) careerFieldRepo.findAll();
        model.addAttribute("cField", careerFields);
        model.addAttribute("interview", new Interview());
        return "create-interview-review";
    }

    @GetMapping("/view/{id}")
    public String showReview(@PathVariable Long id, Model model) {
        Interview interview = this.interviewRepo.findById(id).get();
        model.addAttribute("interview", interview);
        return "view-review";
    }

    @PostMapping
    public String handleCreateInterviewForm(@Valid @ModelAttribute("interview") Interview interview, Errors errors) {
        if (errors.hasErrors()) {
            return "create-interview-review";
        }
        this.interviewRepo.save(interview);
        return "redirect:/reviews";
    }

    @PostMapping("/edit/{id}")
    public String handleEditReviewForm(@PathVariable Long id, @Valid @ModelAttribute("interview") Interview interview, Errors errors) {
        if (errors.hasErrors()) {
            return "view-review";
        }

        try {
            Interview originalReview = this.interviewRepo.findById(id).get();
            updateOriginalReview(originalReview, interview);
            this.interviewRepo.save(originalReview);
        } catch(DataIntegrityViolationException e) {
            return "view-review";
        }

        return "redirect:/reviews";
    }

    private void updateOriginalReview(Interview original, Interview update) {
        //original.setcField(update.getcField());
        original.setTitle(update.getTitle());
        original.setDescription(update.getDescription());
        original.setSalary(update.getSalary());

    }

    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable Long id) {
        this.interviewRepo.deleteById(id);
        return "redirect:/reviews";
    }
}
