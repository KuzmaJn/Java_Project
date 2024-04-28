package sk.stuba.fei.uim.oop.entity.people;

import sk.stuba.fei.uim.oop.entity.organization.OrganizationInterface;

import java.util.*;

public class Person implements PersonInterface {
    private String name;
    private String address;
    private Set<OrganizationInterface> employers = new HashSet<>();

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void addEmployer(OrganizationInterface organization) {
        if (organization == null) {
            throw new IllegalArgumentException("Employer cannot be null");
        }
        employers.add(organization);
    }

    @Override
    public Set<OrganizationInterface> getEmployers() {
        return employers;
    }
}
