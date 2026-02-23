public class CgrRule implements EligibilityRule 
{
    private static final double MIN_CGR = 8.0;

    @Override
    public boolean isSatisfied(StudentProfile student) 
    {
        return student.cgr >= MIN_CGR;
    }

    @Override
    public String getReason() 
    {
        return "CGR below " + MIN_CGR;
    }
}
// Ye class CGR validation ko separate rule bana deti hai, jisse engine open for extension aur closed for modification rehta hai