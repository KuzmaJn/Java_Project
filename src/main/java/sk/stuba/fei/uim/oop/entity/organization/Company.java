package sk.stuba.fei.uim.oop.entity.organization;

import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.*;

public class Company implements OrganizationInterface{
    private String name;
    private Map<PersonInterface, Integer> employees = new HashMap<>();
    private Map<ProjectInterface, Integer> projects = new HashMap<>();
    private int companyBudget;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addEmployee(PersonInterface p, int employment) {
        employees.put(p, employment);
    }

    @Override
    public Set<PersonInterface> getEmployees() {
        return new HashSet<>(employees.keySet());
    }

    @Override
    public int getEmploymentForEmployee(PersonInterface p) {
        return employees.get(p);
    }

    @Override
    public Set<ProjectInterface> getAllProjects() {
        return new HashSet<>(projects.keySet());
    }

    @Override
    public Set<ProjectInterface> getRunningProjects(int year) {
        Set<ProjectInterface> runningProjects = new HashSet<>();
        for(Map.Entry<ProjectInterface, Integer> entry : projects.entrySet()) {
            if (entry.getValue() <= year) {
                runningProjects.add(entry.getKey());
            }
        }
        return runningProjects;
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
