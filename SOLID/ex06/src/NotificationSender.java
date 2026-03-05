public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) { 
        this.audit = audit; 
    }

    public final void send(Notification n) {
        if (n == null) throw new IllegalArgumentException("Notification cannot be null");

        ValidationResult result = validate(n);
        if (!result.isValid()) {
            // If it fails, we throw the error. 
            // The Main class will catch this and log the 3rd entry.
            throw new IllegalArgumentException(result.getErrorMessage());
        }

        performSend(n);
    }

    protected abstract ValidationResult validate(Notification n);
    protected abstract void performSend(Notification n);
}