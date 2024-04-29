package sk.stuba.fei.uim.oop.entity.organization;

import static sk.stuba.fei.uim.oop.utility.Constants.COMPANY_INIT_OWN_RESOURCES;
import sk.stuba.fei.uim.oop.entity.grant.*;

public class Company extends Organization {
    private int companyBudget = COMPANY_INIT_OWN_RESOURCES;

    /**
     * method updates the funds that company has for the given project. If the company has enough funds, the project is funded
     */
    public void projectBudgetUpdateNotification(ProjectInterface project, int year, int budget) {
        if (companyBudget >= budget) {
            addBudgetToProject(project, budget);
            companyBudget -= budget;
        }
        else if (companyBudget > 0) {
            addBudgetToProject(project, companyBudget);
            companyBudget = 0;
        }
    }
}
