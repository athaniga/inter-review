package com.interreview.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "Job title is required")
    private String title;
    @NotBlank(message = "Company or Organization name required")
    private String company;
    private String description;
    @PositiveOrZero(message = "Value can not be negative. For volunteer work, enter 0")
    private double salary;
    //private String uploadedBy; Grab username?

    private LocalDateTime created;
    private LocalDateTime modified;




    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "career_field_id")
    private CareerField careerField;



    public Interview() {
        this.company = "";
        this.title = "";
        this.salary = 0.00;
        this.description = "";
    }


    public Interview(String company, String title, double salary, String description) {
        this.company = company;
        this.title = title;
        this.salary = salary;
        this.description = description;
    }


    public long getId() {
        return this.id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CareerField getCareerField() {
        return careerField;
    }

    public void setCareerField(CareerField careerField) {
        this.careerField = careerField;
    }


    @PrePersist
    public void onCreate()  {
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate() {
        this.setModified(LocalDateTime.now());
    }
}
