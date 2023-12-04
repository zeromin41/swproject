package com.example.software_project.UI;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private boolean graduationProjectChecked = false;
    private boolean educationTrainingChecked = false;
    private boolean internshipChecked = false;
    private boolean licenseChecked = false;
    private boolean toeicChecked = false;
    private boolean thesisChecked = false;
    private double totalScore = 0.0;

    // Getter 및 Setter 메서드들

    public boolean isGraduationProjectChecked() {
        return graduationProjectChecked;
    }

    public void setGraduationProjectChecked(boolean graduationProjectChecked) {
        this.graduationProjectChecked = graduationProjectChecked;
    }

    public boolean isEducationTrainingChecked() {
        return educationTrainingChecked;
    }

    public void setEducationTrainingChecked(boolean educationTrainingChecked) {
        this.educationTrainingChecked = educationTrainingChecked;
    }

    public boolean isInternshipChecked() {
        return internshipChecked;
    }

    public void setInternshipChecked(boolean internshipChecked) {
        this.internshipChecked = internshipChecked;
    }

    public boolean isLicenseChecked() {
        return licenseChecked;
    }

    public void setLicenseChecked(boolean licenseChecked) {
        this.licenseChecked = licenseChecked;
    }

    public boolean isToeicChecked() {
        return toeicChecked;
    }

    public void setToeicChecked(boolean toeicChecked) {
        this.toeicChecked = toeicChecked;
    }

    public boolean isThesisChecked() {
        return thesisChecked;
    }

    public void setThesisChecked(boolean thesisChecked) {
        this.thesisChecked = thesisChecked;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public void addToTotalScore(double value) {
        totalScore += value;
    }
}

