package com.interreview.controllers;

import com.interreview.models.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    @GetMapping
    public String showSignUp(Model model) {
        model.addAttribute("account", new Account());
        return "signup";
    }

    @PostMapping
    public String handleSignUpForm(@ModelAttribute("account") Account account, RedirectAttributes att) {
        att.addFlashAttribute("fName", account.getfName());
        att.addFlashAttribute("lName", account.getlName());
        att.addFlashAttribute("email", account.getEmail());
        att.addFlashAttribute("username", account.getUserName());

        return "redirect:/profile";
    }
}
