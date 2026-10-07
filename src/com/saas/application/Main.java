package com.saas.application;

import com.saas.application.enums.EmployeeStatus;
import com.saas.application.enums.SubscriptionPlan;
import com.saas.application.constants.SaaSConstants;
import com.saas.application.utility.SubscriptionLimitUtil;

public class Main {
    public static void main(String[] args) {
        EmployeeStatus employeeStatus = EmployeeStatus.ACTIVE;
        SubscriptionPlan subscriptionPlan = SubscriptionPlan.PRO;
        int maxEmployees = SaaSConstants.MAX_EMPLOYEES;
        int subscriptionLimit = SubscriptionLimitUtil.getEmployeeLimit(subscriptionPlan);

        System.out.println("Employee Status: "+ employeeStatus);
        System.out.println("Subscription Plan : "+subscriptionPlan);
        System.out.println("Maximum Employees: "+ maxEmployees);
        System.out.println("Subscription Employee Limit: "+subscriptionLimit);
    }
}
