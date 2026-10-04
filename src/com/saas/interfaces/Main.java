import com.saas.interfaces.EmailNotificationService;
import com.saas.interfaces.NotificationServices;
import com.saas.interfaces.SMSNotificationService;

public class Main {
    public static void main(String[] args) {
        NotificationServices emailService = new EmailNotificationService();
        NotificationServices smsService = new SMSNotificationService();

        emailService.sendNotification("teja@gmail.com", "Welcome to Blackroth");
        smsService.sendNotification("BR26JV9995A", "Your OTP is 6399");
    }
}