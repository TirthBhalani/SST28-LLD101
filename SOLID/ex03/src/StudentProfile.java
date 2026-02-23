public class StudentProfile {
    public final String rollNo;
    public final String name;
    public final double cgr;
    public final int attendancePct;
    public final int earnedCredits;
    public final int disciplinaryFlag;

    public StudentProfile(String rollNo, String name, double cgr, int attendancePct, int earnedCredits, int disciplinaryFlag) {
        this.rollNo = rollNo; this.name = name; this.cgr = cgr;
        this.attendancePct = attendancePct; this.earnedCredits = earnedCredits;
        this.disciplinaryFlag = disciplinaryFlag;
    }
}
// Ye simple data holder (DTO) hai jo student ka profile represent karta hai, taaki rules aur engine same structured data pe kaam kar sake