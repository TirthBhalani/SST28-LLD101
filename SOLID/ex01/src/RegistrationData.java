public class RegistrationData 
{
    // final : once a value is set, then baadme we cant change it
    public final String name;
    public final String email;
    public final String phone;
    public final String program;

    public RegistrationData(String name, String email, String phone, String program) 
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.program = program;
    }
}