import java.util.*;

public interface StudentRepository
{
    void save(StudentRecord record);
    int count();
    List<StudentRecord> all();
}

/*
    ye isliye kiya taki we can de couple the onbordingservive from the concrete fakedb.
*/