public class SaaSSubscription {
    public static void main(String[] args) {
        // --- 1. Variables & Assignment Operators (=) ---
        double baseSubscriptionPrice = 100.0;
        double addonPrice = 25.0;
        double discountAmount = 15.0;

        boolean isEnterpriseClient = true;
        boolean isAccountActive = true;

        // --- 2. Arithmetic Operators (+, -, *) ---
        double finalSubscriptionAmount = baseSubscriptionPrice + addonPrice - discountAmount;

        // --- 3. Compound Assignment Operators (+=, -=) ---
        double promotionalCredit = 5.0;
        finalSubscriptionAmount -= promotionalCredit;

        // --- 4. Comparison Operators (==, >=) ---
        boolean qualifiesForVolumeDiscount = finalSubscriptionAmount >= 100.0;
        boolean isExactPriceMatch = finalSubscriptionAmount == 105.0;

        // --- 5. Logical Operators (&&, ||, !) ---
        // Check if invoice can be generated
        boolean canGenerateInvoice = isAccountActive && (isEnterpriseClient || qualifiesForVolumeDiscount);

        // --- Output Results ---
        System.out.println("--- SaaS Subscription Breakdown ---");
        System.out.println("Base Price: " + baseSubscriptionPrice);
        System.out.println("Add-on Price: " + addonPrice);
        System.out.println("Discount: " + discountAmount);
        System.out.println("Promo Credit: " + promotionalCredit);
        System.out.println("Final Subscription Amount: " + finalSubscriptionAmount);
        System.out.println("Qualifies for Volume Discount: " + qualifiesForVolumeDiscount);
        System.out.println("Can Generate Invoice: " + canGenerateInvoice);
    }
}