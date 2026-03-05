public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit); }

    @Override
    protected ValidationResult validate(Notification n) {
        return ValidationResult.ok();
    }

    @Override
    protected void performSend(Notification n) {
        // only uses phone and body. 
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
    }
}