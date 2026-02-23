import java.util.*;

public class RegistrationValidator 
{
    private static final Set<String> ALLOWED_PROGRAMS = Set.of("CSE", "AI", "SWE");

    public List<String> validate(RegistrationData data) 
    {
        List<String> errors = new ArrayList<>();
        
        if (data.name.isBlank()) 
            errors.add("name is required");
        if (data.email.isBlank() || !data.email.contains("@")) 
            errors.add("email is invalid");
        if (data.phone.isBlank() || !data.phone.chars().allMatch(Character::isDigit)) 
            errors.add("phone is invalid");
        if (!ALLOWED_PROGRAMS.contains(data.program)) 
            errors.add("program is invalid");
        
        return errors;
    }
}

/*  
Introduced it to de couple things
*/