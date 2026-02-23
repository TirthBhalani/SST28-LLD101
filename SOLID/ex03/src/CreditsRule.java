public class CreditsRule implements EligibilityRule 
{
    private static final int MIN_CREDITS = 20;

    @Override
    public boolean isSatisfied(StudentProfile student) 
    {
        return student.earnedCredits >= MIN_CREDITS;
    }

    @Override
    public String getReason() {
        return "credits below " + MIN_CREDITS;
    }
}
// Ye rule earned credits check karta hai aur evaluation logic ko modular aur loosely coupled banata hai