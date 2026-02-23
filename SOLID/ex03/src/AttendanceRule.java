public class AttendanceRule implements EligibilityRule
{
    private static final int MIN_ATTENDANCE = 75;

    @Override
    public boolean isSatisfied(StudentProfile student) 
    {
        return student.attendancePct >= MIN_ATTENDANCE;
    }

    @Override
    public String getReason() 
    {
        return "attendance below " + MIN_ATTENDANCE;
    }
}

// Ye class attendance rule ko main engine se decouple karti hai, taaki new rules easily add ho sake without modifying core logic