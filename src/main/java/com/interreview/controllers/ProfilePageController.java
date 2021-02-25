package com.interreview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfilePageController {

    @GetMapping
    public String showProfilePage(@ModelAttribute("fName") Object flashFName, @ModelAttribute("lName") Object flashLName,
                                  @ModelAttribute("email") Object flashEmail,
                                  @ModelAttribute("username") Object flashUsername, Model model)
    {

        model.addAttribute("fName", flashFName);
        model.addAttribute("lName", flashLName);
        model.addAttribute("email", flashEmail);
        model.addAttribute("username", flashUsername);
        return "profile-page";
    }
}
