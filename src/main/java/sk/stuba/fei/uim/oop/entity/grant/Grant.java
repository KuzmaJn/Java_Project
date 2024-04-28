package sk.stuba.fei.uim.oop.entity.grant;

import sk.stuba.fei.uim.oop.entity.people.PersonInterface;
import sk.stuba.fei.uim.oop.entity.organization.OrganizationInterface;
import java.util.*;

public class Grant implements GrantInterface{
    private String identifier;
    private int year;
    private AgencyInterface agency;
    private int budget;
    private int remainingBudget;
    private Set<ProjectInterface> registeredProjects = new HashSet<>();
    private GrantState state;

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public AgencyInterface getAgency() {
        return this.agency;
    }

    @Override
    public void setAgency(AgencyInterface agency) {
        this.agency = agency;
    }

    @Override
    public int getBudget() {
        return this.budget;
    }

    @Override
    public void setBudget(int budget) {
        this.budget = budget;
        this.remainingBudget = budget;
    }

    @Override
    public int getRemainingBudget() {
        return this.remainingBudget;
    }

    @Override
    public int getBudgetForProject(ProjectInterface project) {
        return 0;
    }

    @Override
    public boolean registerProject(ProjectInterface project) {
        if(state != GrantState.STARTED) return false;
        if(project.getStartingYear() != year) return false;
        if(project.getAllParticipants().isEmpty()) return false;
        if(project.getApplicant() == null) return false;

        registeredProjects.add(project);
        return true;
    }

    @Override
    public Set<ProjectInterface> getRegisteredProjects() {
        return registeredProjects;
    }

    @Override
    public GrantState getState() {
        return state;
    }

    @Override
    public void callForProjects() {

    }

    @Override
    public void evaluateProjects() {

    }

    @Override
    public void closeGrant() {

    }
}
