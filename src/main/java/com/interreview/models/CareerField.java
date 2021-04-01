package com.interreview.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CareerField {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String fieldName;
    private int avgSalary;
    private int avgWorkHours;

    public CareerField() {

    }

    public CareerField(String fieldName, int avgSalary, int avgWorkHours) {
        this.fieldName = fieldName;
        this.avgSalary = avgSalary;
        this.avgWorkHours = avgWorkHours;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(int avgSalary) {
        this.avgSalary = avgSalary;
    }

    public int getAvgWorkHours() {
        return avgWorkHours;
    }

    public void setAvgWorkHours(int avgWorkHours) {
        this.avgWorkHours = avgWorkHours;
    }
}
