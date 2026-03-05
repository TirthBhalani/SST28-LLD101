public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    protected ValidationResult validate(Notification n) {
        return ValidationResult.ok(); // Email is unrestricted
    }

    @Override
    protected void performSend(Notification n) {
        // We still respect the "legacy" truncation for the demo,(bcz we want to preserve output)
        // but it's now within the send step.
        String body = n.body;
        if (body != null && body.length() > 40) body = body.substring(0, 40);
        
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body);
        audit.add("email sent");
    }
}