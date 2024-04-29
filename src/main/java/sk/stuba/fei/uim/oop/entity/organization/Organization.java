package sk.stuba.fei.uim.oop.entity.organization;

import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.*;

public class Organization implements OrganizationInterface{
    private String name;
    private final Map<PersonInterface, Integer> employees = new HashMap<>(); // key: employee, value: employment
    private final Map<ProjectInterface, Integer> projects = new HashMap<>(); // key: project, value: budget funded by organization (only in company, in university 0)

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
        return new HashSet<>(projects.keySet());        // creates a new set with the key values of the map
    }

    @Override
    public Set<ProjectInterface> getRunningProjects(int year) {
        Set<ProjectInterface> runningProjects = new HashSet<>();
        for(ProjectInterface project : projects.keySet()) {
            if (project.getEndingYear() <= year) {
                runningProjects.add(project);
            }
        }
        return runningProjects;
    }

    @Override
    public void registerProjectInOrganization(ProjectInterface project) {
        projects.put(project, 0);
    }

    public void addBudgetToProject(ProjectInterface project, int budget) {
        projects.put(project, projects.get(project) + budget);
    }

    /**
     * @return total budget assigned to project with grant and organization funds
     */

    @Override
    public int getProjectBudget(ProjectInterface pi) {
        if(!projects.containsKey(pi)) {
            return 0;
        }
        return pi.getTotalBudget() + projects.get(pi);
    }

    @Override
    public int getBudgetForAllProjects() {
        int sum = 0;
        for (ProjectInterface project : projects.keySet()){
            sum += getProjectBudget(project);
        }
        return sum;
    }

    @Override
    public void projectBudgetUpdateNotification(ProjectInterface pi, int year, int budgetForYear) {

    }
}
