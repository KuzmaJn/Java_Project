package sk.stuba.fei.uim.oop.entity.organization;

import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Organization implements OrganizationInterface{
    private String name;
    private Map<PersonInterface, Integer> employees = new HashMap<>(); // key: employee, value: employment
    private Set<ProjectInterface> projects = new HashSet<>();

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
        if(p == null || employment < 0) {
            throw new IllegalArgumentException("Person or employment cannot be null.");
        }
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
        return projects;
    }

    @Override
    public Set<ProjectInterface> getRunningProjects(int year) {
        Set<ProjectInterface> runningProjects = new HashSet<>();
        for(ProjectInterface project : projects) {
            if (project.getEndingYear() <= year) {
                runningProjects.add(project);
            }
        }
        return runningProjects;
    }

    @Override
    public void registerProjectInOrganization(ProjectInterface project) {
        if(project == null) {
            throw new IllegalArgumentException("Project cannot be null.");
        }
        projects.add(project);
    }

    @Override
    public int getProjectBudget(ProjectInterface pi) {
        if(pi == null) {
            throw new IllegalArgumentException("Project cannot be null.");
        }
        return pi.getTotalBudget();
    }

    @Override
    public int getBudgetForAllProjects() {
        int sum = 0;
        for (ProjectInterface project : projects) {
            sum += getProjectBudget(project);
        }
        return sum;
    }

    @Override
    public void projectBudgetUpdateNotification(ProjectInterface pi, int year, int budgetForYear) {

    }
}
