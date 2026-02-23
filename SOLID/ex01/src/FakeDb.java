import java.util.*;

public class FakeDb implements StudentRepository 
{
    private final List<StudentRecord> students = new ArrayList<>();

    @Override
    public void save(StudentRecord record) 
    {
        students.add(record);
    }

    @Override
    public int count() 
    {
        return students.size();
    }

    @Override
    public List<StudentRecord> all() 
    {
        return Collections.unmodifiableList(students);
    }
}


/*
    If in future we will want to shift to SQLDB then we can make another sqldb class that implement the same interface
*/