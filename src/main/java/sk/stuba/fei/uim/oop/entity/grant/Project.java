package sk.stuba.fei.uim.oop.entity.grant;

import sk.stuba.fei.uim.oop.entity.organization.*;
import sk.stuba.fei.uim.oop.entity.people.*;
import java.util.*;

import static sk.stuba.fei.uim.oop.utility.Constants.PROJECT_DURATION_IN_YEARS;

public class Project implements ProjectInterface{
    private String projectName;
    private int startingYear;
    private int endingYear;
    private int []totalBudget;
    private Set<PersonInterface> participants = new HashSet<>();
    private OrganizationInterface applicant;

    @Override
    public String getProjectName() {
        return projectName;
    }
    @Override
    public void setProjectName(String name) {
        this.projectName = name;
    }

    @Override
    public int getStartingYear() {
        return startingYear;
    }
    @Override
    public void setStartingYear(int year) {
        this.startingYear = year;
        this.endingYear = year + PROJECT_DURATION_IN_YEARS;
    }
    @Override
    public int getEndingYear() {
        return endingYear;
    }

    @Override
    public int getBudgetForYear(int year) {
        return totalBudget[year - getStartingYear()];
    }
    @Override
    public void setBudgetForYear(int year, int budget) {
        totalBudget[year - getStartingYear()] = budget;
    }

    @Override
    public int getTotalBudget() {
        int sum = 0;
        for (int i = 0; i < PROJECT_DURATION_IN_YEARS; i++) {
            sum += totalBudget[i];
        }
        return sum;
    }

    @Override
    public void addParticipant(PersonInterface participant) {
        if(participant == null){
            throw new IllegalArgumentException("Participant cannot be null.");
        }
        if (participant.getEmployers().contains(applicant)){
            participants.add(participant);
        }
    }

    @Override
    public Set<PersonInterface> getAllParticipants() {
        return participants;
    }

    @Override
    public OrganizationInterface getApplicant() {
        return applicant;
    }

    @Override
    public void setApplicant(OrganizationInterface applicant) {
        this.applicant = applicant;
    }
}
