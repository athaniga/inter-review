package com.interreview.controllers;

import com.interreview.models.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    @GetMapping
    public String showSignUp(Model model) {
        model.addAttribute("account", new Account());
        return "signup";
    }

    @PostMapping
    public String handleSignUpForm(@ModelAttribute("account") Account account) {
        System.out.println(account.getEmail());
        System.out.println(account.getUserName());

        return "redirect:/";
    }
}
