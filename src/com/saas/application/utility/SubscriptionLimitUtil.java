package com.saas.application.utility;

import com.saas.application.enums.SubscriptionPlan;

public final class SubscriptionLimitUtil {
    private SubscriptionLimitUtil(){

    }
    public static int getEmployeeLimit(SubscriptionPlan plan){
        switch (plan){
            case FREE:
                return 5;
            case BASIC:
                return 25;
            case PRO:
                return 100;
            case ENTERPRISE:
                return 500;
            default:
                return 0;
        }
    }
}
