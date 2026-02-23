public class SmsSender extends NotificationSender 
{
    public SmsSender(AuditLog audit) 
    {
        super(audit);
    }

    @Override
    protected void validate(Notification n) 
    {
        if (n.phone == null || n.phone.isBlank()) 
        {
            throw new IllegalArgumentException("Phone number is required");
        }
    }

    @Override
    protected void doSend(Notification n) 
    {
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
    }
}
// Ye SmsSender apni channel-specific validation karta hai but base send contract ko follow karta hai, so isko NotificationSender reference se safely use kiya ja sakta hai