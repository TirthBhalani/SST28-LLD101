public class DisciplinaryRule implements EligibilityRule 
{
    @Override
    public boolean isSatisfied(StudentProfile student) 
    {
        return student.disciplinaryFlag == LegacyFlags.NONE;
    }

    @Override
    public String getReason() 
    {
        return "disciplinary flag present";
    }
} 
// Ye class disciplinary check ko separate rule bana deti hai, so engine ko change kiye bina new rules plug-in kar sakte hai (clean OCP support)