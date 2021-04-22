package com.interreview.controllers;

import com.interreview.data.UserRepository;
import com.interreview.models.Interview;
import com.interreview.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/signup")
public class AccountController {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getSignupPage(Model model) {
        model.addAttribute("user", new User());
        return "create-signup";
    }

    @PostMapping
    public String handleCreateAccountForm(@Valid @ModelAttribute("user") User user, Errors errors) {
        if (errors.hasErrors()) {
            return "create-signup";
        }
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(User.Role.ROLE_USER));
        this.userRepo.save(user);
        return "redirect:/";
    }
}
