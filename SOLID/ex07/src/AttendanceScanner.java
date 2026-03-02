public class AttendanceScanner implements Powerable, AttendanceScannable {
    @Override public void powerOn() { /* Scanner Power On Logic */ }
    @Override public void powerOff() { /* No output for scanner off */ }
    @Override public int scanAttendance() { return 3; }
}