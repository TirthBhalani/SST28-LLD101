public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    protected ValidationResult validate(Notification n) {
        // Precondition: WhatsApp requires specific phone formatting.
        if (n.phone == null || !n.phone.startsWith("+")) {
            return ValidationResult.fail("phone must start with + and country code");
        }
        return ValidationResult.ok();
    }

    @Override
    protected void performSend(Notification n) {
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
    }
}