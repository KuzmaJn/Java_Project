package sk.stuba.fei.uim.oop.entity.organization;

import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.Set;

public class University implements OrganizationInterface{
    //
    private String name;
    private Set<PersonInterface> employees;
    private Set<ProjectInterface> projects;


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addEmployee(PersonInterface p, int employment) {

    }

    @Override
    public Set<PersonInterface> getEmployees() {
        return Set.of();
    }

    @Override
    public int getEmploymentForEmployee(PersonInterface p) {
        return 0;
    }

    @Override
    public Set<ProjectInterface> getAllProjects() {
        return Set.of();
    }

    @Override
    public Set<ProjectInterface> getRunningProjects(int year) {
        return Set.of();
    }

    @Override
    public void registerProjectInOrganization(ProjectInterface project) {

    }

    @Override
    public int getProjectBudget(ProjectInterface pi) {
        return 0;
    }

    @Override
    public int getBudgetForAllProjects() {
        return 0;
    }

    @Override
    public void projectBudgetUpdateNotification(ProjectInterface pi, int year, int budgetForYear) {

    }
}
