import java.util.*;

public class AuditLog {
    private final List<String> entries = new ArrayList<>();
    public void add(String e) { entries.add(e); }
    public int size() { return entries.size(); }
}
// Ye simple audit helper hai jo notifications ke logs store karta hai, taaki sending logic aur tracking responsibility cleanly separated rahe