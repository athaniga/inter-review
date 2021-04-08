package com.interreview.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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



    @OneToMany(mappedBy = "careerField", cascade = CascadeType.PERSIST)
    private Set<Interview> interviews = new HashSet<>();

    public Set<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(Set<Interview> interviews) {
        this.interviews = interviews;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CareerField)) {
            return false;
        }

        CareerField c = (CareerField) o;
        return this.fieldName.equals(c.fieldName);
    }

    @Override
    public int hashCode() {
        return this.fieldName.hashCode();
    }

    @Override
    public String toString() {
        return fieldName;
    }
}
