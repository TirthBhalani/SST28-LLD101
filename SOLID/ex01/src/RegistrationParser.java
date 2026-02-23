import java.util.*;

public class RegistrationParser 
{
    public RegistrationData parse(String raw) 
    {
        // LinkedHashMap insertion/access order maintain karta hai using doubly linked list, hashmap se ordering maintain nahi kar sakte.
        Map<String, String> kv = new LinkedHashMap<>();
        
        String[] parts = raw.split(";");
        for (String p : parts) 
            {
            String[] t = p.split("=", 2);
            if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        }
        
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");
        
        return new RegistrationData(name, email, phone, program);
    }
}

/*
    doing the same thing jo ham onboardignservice me kar rahe the, just de coupling things to try to make it follow SRP.

*/