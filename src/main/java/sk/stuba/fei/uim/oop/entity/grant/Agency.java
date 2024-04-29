package sk.stuba.fei.uim.oop.entity.grant;

import java.util.*;

public class Agency implements AgencyInterface{
    private String name;
    private final Map<GrantInterface, Integer> grants = new HashMap<>();  // key: grant, value: year grant was issued

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addGrant(GrantInterface gi, int year) {
        grants.put(gi, year);
    }


    @Override
    public Set<GrantInterface> getAllGrants() {
        return new HashSet<>(grants.keySet());
    }

    @Override
    public Set<GrantInterface> getGrantsIssuedInYear(int year) {
        Set<GrantInterface> grantsInYear = new HashSet<>();
        for(Map.Entry<GrantInterface, Integer> entry : grants.entrySet()) {
            if (entry.getValue() == year) {
                grantsInYear.add(entry.getKey());
            }
        }
        return grantsInYear;
    }
}
