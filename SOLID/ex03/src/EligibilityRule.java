public interface EligibilityRule 
{
    boolean isSatisfied(StudentProfile student);
    String getReason();
}
// Ye common abstraction hai jiske through har rule plug-in hota hai, so new rule add karne ke liye bas nayi class banao without touching engine