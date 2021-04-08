package com.interreview.controllers;

import com.interreview.data.CareerFieldRepository;
import com.interreview.models.CareerField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/career-fields")
public class CareerFieldController {

    private CareerFieldRepository cFieldRepo;

    @Autowired
    public CareerFieldController(CareerFieldRepository cFieldRepo) {
        this.cFieldRepo = cFieldRepo;
    }

    @GetMapping()
    public String showCareerFields(Model model) {
        List<CareerField> cFields = (List<CareerField>) this.cFieldRepo.findAll();
        model.addAttribute("cFields", cFields);
        return "display-career-fields";
    }

}
