package com.myspringboot.fristjobproject.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myspringboot.fristjobproject.company.Company;
import jakarta.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private long minSal;
    private long maxSal;
    private String location;

    @ManyToOne
    private Company company;

    public Job() {
    }

    public Job(long id, String title, String description, long minSal, long maxSal, String location, Company company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSal = minSal;
        this.maxSal = maxSal;
        this.location = location;
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMinSal() {
        return minSal;
    }

    public void setMinSal(long minSal) {
        this.minSal = minSal;
    }

    public long getMaxSal() {
        return maxSal;
    }

    public void setMaxSal(long maxSal) {
        this.maxSal = maxSal;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", minSal=" + minSal +
                ", maxSal=" + maxSal +
                ", location='" + location + '\'' +
                '}';
    }
}
