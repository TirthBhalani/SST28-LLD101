import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t1 = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing");
        System.out.println("Original: " + t1);

        // Service now returns NEW instances
        IncidentTicket t2 = service.assign(t1, "agent@example.com");
        IncidentTicket t3 = service.escalateToCritical(t2);

        System.out.println("After Assign (t2):   " + t2);
        System.out.println("After Escalate (t3): " + t3);
        System.out.println("t1 is still:         " + t1); // Unchanged!

        // Demonstrate failed external mutation
        try {
            List<String> tags = t3.getTags();
            tags.add("HACK"); 
        } catch (UnsupportedOperationException e) {
            System.out.println("\nExternal mutation blocked by unmodifiable list!");
        }
    }
}