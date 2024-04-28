package sk.stuba.fei.uim.oop.entity.grant;

import sk.stuba.fei.uim.oop.entity.people.PersonInterface;
import sk.stuba.fei.uim.oop.entity.organization.OrganizationInterface;
import java.util.*;

import static sk.stuba.fei.uim.oop.utility.Constants.MAX_EMPLOYMENT_PER_AGENCY;

public class Grant implements GrantInterface {
    private String identifier;
    private int year;
    private AgencyInterface agency;
    private int budget;
    private int remainingBudget;
    private Map<ProjectInterface, Integer> registeredProjects = new HashMap<>();
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
        return registeredProjects.get(project);
    }

    @Override
    public boolean registerProject(ProjectInterface project) {
        if (state != GrantState.STARTED) return false;
        if (project.getStartingYear() != year) return false;
        if (project.getAllParticipants().isEmpty()) return false;
        if (project.getApplicant() == null) return false;

        registeredProjects.put(project, null);
        return true;
    }

    @Override
    public Set<ProjectInterface> getRegisteredProjects() {
        return new HashSet<>(registeredProjects.keySet());
    }

    @Override
    public GrantState getState() {
        return state;
    }

    @Override
    public void callForProjects() {
        state = GrantState.STARTED;
    }

    @Override
    public void evaluateProjects() {
        state = GrantState.EVALUATING;

        // Evaluate employees employments in agency
        for (ProjectInterface project : registeredProjects.keySet()) {                                  // iterating over all projects
            boolean passed = true;                                                                      // to check if the project's participants have employments in order

            for (PersonInterface participant : project.getAllParticipants()) {                           // iterating over all participants
                int employment = 0;
                employment += project.getApplicant().getEmploymentForEmployee(participant);             // adding possible employment to the variable
                for (GrantInterface grant : agency.getAllGrants()) {                                     // iterating over all grants that the same agency has issued

                    for (ProjectInterface p : grant.getRegisteredProjects()) {                           // iterating over all projects that are registered in the grant
                        if (p.getEndingYear() >= year && p.getTotalBudget() != 0                        // checking if the project is still running and have been funded
                                && p.getAllParticipants().contains(participant)) {                      // checking if the participant is in the project
                            employment += p.getApplicant().getEmploymentForEmployee(participant);       // if all yes, add the employment to the variable
                            if (employment > MAX_EMPLOYMENT_PER_AGENCY) {                               // checking if the employment is too high
                                passed = false;                                                         // if yes, set the flag to false
                                break;                                                                  // and break the loop
                            }
                        }
                    }
                    if (!passed)
                        break;                                                                  // if the flag is false, break the loop
                }
                if (!passed) break;
            }
            if (!passed) {
                registeredProjects.put(project, 0);                                                     // if the flag is false, set the project's budget to 0
            }
        }

        // Dividing budget between projects

        int count = 0;
        for (ProjectInterface project : registeredProjects.keySet()) {
            if (registeredProjects.get(project) == null) count++;
        }
        count = count / 2;
        int budgetPerProject = budget / count;
        for (ProjectInterface project : registeredProjects.keySet()) {
            if (registeredProjects.get(project) == null) {
                if(remainingBudget >= budgetPerProject) {
                    registeredProjects.put(project, budgetPerProject);
                    remainingBudget -= budgetPerProject;
                }
                    registeredProjects.put(project, 0);
            }
        }

    }

    @Override
    public void closeGrant () {

    }
}
