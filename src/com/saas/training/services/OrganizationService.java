package com.saas.training.services;

import com.saas.training.model.Organization;
import com.saas.training.model.Subscription;

public class OrganizationService {
    private Organization organization;
    public void createOrganization(int id, String name, Subscription subscription){
        organization = new Organization(id, name, subscription);
    }
    public Organization getOrganization(){
        return organization;
    }
    public void viewSubscription(){
        if (organization == null){
            System.out.println("Organization is not created.");
            return;
        }
        System.out.println("Organization :"+organization.getOrganizationName());
        System.out.println("Subscription :"+organization.getSubscription());
    }
}
