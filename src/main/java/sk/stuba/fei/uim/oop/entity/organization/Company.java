package sk.stuba.fei.uim.oop.entity.organization;

import static sk.stuba.fei.uim.oop.utility.Constants.COMPANY_INIT_OWN_RESOURCES;

public class Company extends Organization {
    private final int companyBudget = COMPANY_INIT_OWN_RESOURCES;

    public void getProjectBudget() {
        System.out.println("Company budget: " + companyBudget);
    }
}
