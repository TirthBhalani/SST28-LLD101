import java.util.*;

public class OnboardingService 
{
    private final StudentRepository repository;
    private final RegistrationParser parser;
    private final RegistrationValidator validator;
    private final OnboardingPrinter printer;

    public OnboardingService(StudentRepository repository, 
                             RegistrationParser parser,
                             RegistrationValidator validator,
                             OnboardingPrinter printer) 
    {
        this.repository = repository;
        this.parser = parser;
        this.validator = validator;
        this.printer = printer;
    }

    public void registerFromRawInput(String raw) 
    {
        printer.printInput(raw);
        
        // Pehle data parse karenge
        RegistrationData data = parser.parse(raw);
        
        // then Validate karenge
        List<String> errors = validator.validate(data);
        if (!errors.isEmpty()) {
            printer.printValidationErrors(errors);
            return;
        }
        
        // Generate ID 
        String id = IdUtil.nextStudentId(repository.count());
        
        // then create a record
        StudentRecord record = new StudentRecord(id, data.name, data.email, data.phone, data.program);
        
        // Save ( abhi in memory ho raha hai )
        repository.save(record);
        
        // Printing ki sahi se ho gaya
        printer.printSuccess(id, repository.count());
        printer.printStudentRecord(record);
    }
}