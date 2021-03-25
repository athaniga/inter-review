package com.interreview.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank(message = "Career field is required")
    private String cField;
    @NotBlank(message = "Job title is required")
    private String title;
    private String description;
    private double salary;
    //private String uploadedBy; Grab username?

    private LocalDateTime created;
    private LocalDateTime modified;

    public Interview() {
        this.cField = "";
        this.title = "";
        this.salary = 0.00;
        this.description = "";
    }

    public Interview(String cField, String title) {
        this.cField = cField;
        this.title = title;
    }

    public Interview(String cField, String title, double salary) {
        this.cField = cField;
        this.title = title;
        this.salary = salary;
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

    public String getcField() {
        return cField;
    }

    public void setcField(String cField) {
        this.cField = cField;
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
