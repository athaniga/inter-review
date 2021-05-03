package com.interreview.controllers;

import com.interreview.data.InterviewRepository;
import com.interreview.models.Interview;
import com.interreview.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ViewReviewsController {

    private InterviewRepository interviewRepo;

    @Autowired
    public ViewReviewsController(InterviewRepository interviewRepository) {
        this.interviewRepo = interviewRepository;
    }

    @GetMapping
    public String showReviewsPage(Model model, @AuthenticationPrincipal User user) {
        List<Interview> interviews = (List<Interview>) this.interviewRepo.findAll();
        model.addAttribute("user", user);
        model.addAttribute("interviews", interviews);
        return "display-reviews";
    }
}
