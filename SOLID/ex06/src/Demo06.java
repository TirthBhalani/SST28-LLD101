public class Demo06 {
    public static void main(String[] args) {
        System.out.println("=== Notification Demo ===");
        AuditLog audit = new AuditLog();

        Notification n = new Notification(
            "Welcome", 
            "Hello and welcome to SST!", 
            "riya@sst.edu", 
            "9876543210" // Invalid for WA
        );

        NotificationSender[] senders = {
            new EmailSender(audit),
            new SmsSender(audit),
            new WhatsAppSender(audit)
        };

        for (NotificationSender sender : senders) {
            try {
                sender.send(n);
            } catch (IllegalArgumentException ex) {
                System.out.println("WA ERROR: " + ex.getMessage());
                // This line ensures we get the 3rd audit entry even on failure
                audit.add("WA failed"); 
            }
        }

        System.out.println("AUDIT entries=" + audit.size());
    }
}